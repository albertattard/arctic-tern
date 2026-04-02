package game.arctictern.application;

import game.arctictern.domain.IntakeState;
import game.arctictern.domain.WorkflowState;
import game.arctictern.persistence.repository.PlanningSessionRepository;
import game.arctictern.persistence.repository.SessionDecisionRepository;
import game.arctictern.persistence.repository.SessionMessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class SessionWorkflowServiceTest {

    @Autowired
    private SessionWorkflowService sessionWorkflowService;

    @Autowired
    private PlanningSessionRepository sessionRepository;

    @Autowired
    private SessionMessageRepository messageRepository;

    @Autowired
    private SessionDecisionRepository decisionRepository;

    @BeforeEach
    void resetDatabase() {
        decisionRepository.deleteAll();
        messageRepository.deleteAll();
        sessionRepository.deleteAll();
    }

    @Test
    void createsAndPersistsNewSession() {
        var session = sessionWorkflowService.createSession();

        assertThat(session.id()).isNotNull();
        assertThat(session.state()).isEqualTo(WorkflowState.INTAKE);
        assertThat(sessionRepository.findById(session.id())).isPresent();
    }

    @Test
    void routesGenericPromptToClarification() {
        var session = sessionWorkflowService.createSession();
        sessionWorkflowService.addUserMessage(session.id(), "I want to build a web application.");

        var assessment = sessionWorkflowService.advanceIntake(session.id());
        var persisted = sessionWorkflowService.getSession(session.id());

        assertThat(assessment.nextState()).isEqualTo(IntakeState.NEEDS_CLARIFICATION);
        assertThat(persisted.state()).isEqualTo(WorkflowState.NEEDS_CLARIFICATION);
        assertThat(sessionWorkflowService.getDecisions(session.id()))
                .singleElement()
                .satisfies(decision -> {
                    assertThat(decision.outcome()).isEqualTo(IntakeState.NEEDS_CLARIFICATION.name());
                    assertThat(decision.rationale()).contains("clarification");
                });
    }

    @Test
    void routesProblemStatementToDiagnosis() {
        var session = sessionWorkflowService.createSession();
        sessionWorkflowService.addUserMessage(session.id(), "My team is overloaded and we need to fix this.");

        var assessment = sessionWorkflowService.advanceIntake(session.id());
        var persisted = sessionWorkflowService.getSession(session.id());

        assertThat(assessment.nextState()).isEqualTo(IntakeState.NEEDS_DIAGNOSIS);
        assertThat(persisted.state()).isEqualTo(WorkflowState.NEEDS_DIAGNOSIS);
    }

    @Test
    void routesDecisionQuestionToDecisionSupport() {
        var session = sessionWorkflowService.createSession();
        sessionWorkflowService.addUserMessage(session.id(), "Should we migrate from Java 17 to Java 21?");

        var assessment = sessionWorkflowService.advanceIntake(session.id());
        var persisted = sessionWorkflowService.getSession(session.id());

        assertThat(assessment.nextState()).isEqualTo(IntakeState.NEEDS_DECISION_SUPPORT);
        assertThat(persisted.state()).isEqualTo(WorkflowState.NEEDS_DECISION_SUPPORT);
    }

    @Test
    void routesExperimentPromptToPlanReady() {
        var session = sessionWorkflowService.createSession();
        sessionWorkflowService.addUserMessage(session.id(), "I want to test whether users care about this feature.");

        var assessment = sessionWorkflowService.advanceIntake(session.id());
        var persisted = sessionWorkflowService.getSession(session.id());

        assertThat(assessment.nextState()).isEqualTo(IntakeState.PLAN_READY);
        assertThat(persisted.state()).isEqualTo(WorkflowState.PLAN_READY);
        assertThat(sessionWorkflowService.getDecisions(session.id()))
                .singleElement()
                .satisfies(decision -> assertThat(decision.signals()).isNotEmpty());
    }
}
