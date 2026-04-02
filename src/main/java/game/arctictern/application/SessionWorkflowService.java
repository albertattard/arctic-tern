package game.arctictern.application;

import game.arctictern.domain.DecisionType;
import game.arctictern.domain.MessageRole;
import game.arctictern.domain.WorkflowState;
import game.arctictern.persistence.entity.PlanningSessionEntity;
import game.arctictern.persistence.entity.SessionDecisionEntity;
import game.arctictern.persistence.entity.SessionMessageEntity;
import game.arctictern.persistence.repository.PlanningSessionRepository;
import game.arctictern.persistence.repository.SessionDecisionRepository;
import game.arctictern.persistence.repository.SessionMessageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SessionWorkflowService {

    private final PlanningSessionRepository sessionRepository;
    private final SessionMessageRepository messageRepository;
    private final SessionDecisionRepository decisionRepository;
    private final IntakeAssessor intakeAssessor;

    public SessionWorkflowService(
            PlanningSessionRepository sessionRepository,
            SessionMessageRepository messageRepository,
            SessionDecisionRepository decisionRepository,
            IntakeAssessor intakeAssessor
    ) {
        this.sessionRepository = sessionRepository;
        this.messageRepository = messageRepository;
        this.decisionRepository = decisionRepository;
        this.intakeAssessor = intakeAssessor;
    }

    @Transactional
    public PlanningSessionView createSession() {
        var session = sessionRepository.save(new PlanningSessionEntity());
        return toView(session);
    }

    @Transactional
    public void addUserMessage(UUID sessionId, String content) {
        var session = findSession(sessionId);
        messageRepository.save(new SessionMessageEntity(session, MessageRole.USER, content));
    }

    @Transactional
    public IntakeAssessment advanceIntake(UUID sessionId) {
        var session = findSession(sessionId);
        var latestMessage = messageRepository
                .findTopBySessionIdAndRoleOrderByCreatedAtDesc(sessionId, MessageRole.USER)
                .orElseThrow(() -> new IllegalStateException("Cannot assess intake without a user message."));

        var assessment = intakeAssessor.assess(latestMessage.getContent());

        session.setState(WorkflowState.fromIntakeState(assessment.nextState()));
        sessionRepository.save(session);

        decisionRepository.save(new SessionDecisionEntity(
                session,
                DecisionType.INTAKE_ASSESSMENT,
                assessment.nextState().name(),
                assessment.rationale(),
                assessment.signals()
        ));

        return assessment;
    }

    @Transactional(readOnly = true)
    public PlanningSessionView getSession(UUID sessionId) {
        return toView(findSession(sessionId));
    }

    @Transactional(readOnly = true)
    public List<DecisionRecordView> getDecisions(UUID sessionId) {
        return decisionRepository.findAllBySessionIdOrderByCreatedAtAsc(sessionId)
                .stream()
                .map(decision -> new DecisionRecordView(
                        decision.getId(),
                        decision.getDecisionType(),
                        decision.getOutcome(),
                        decision.getRationale(),
                        decision.getSignals(),
                        decision.getCreatedAt()
                ))
                .toList();
    }

    private PlanningSessionEntity findSession(UUID sessionId) {
        return sessionRepository.findById(sessionId)
                .orElseThrow(() -> new EntityNotFoundException("Session not found: " + sessionId));
    }

    private PlanningSessionView toView(PlanningSessionEntity session) {
        return new PlanningSessionView(
                session.getId(),
                session.getState(),
                session.getCreatedAt(),
                session.getUpdatedAt()
        );
    }
}
