package game.arctictern.persistence.entity;

import game.arctictern.domain.DecisionType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "session_decisions")
public class SessionDecisionEntity {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "session_id", nullable = false)
    private PlanningSessionEntity session;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DecisionType decisionType;

    @Column(nullable = false)
    private String outcome;

    @Column(nullable = false, length = 4000)
    private String rationale;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "session_decision_signals", joinColumns = @JoinColumn(name = "decision_id"))
    @OrderColumn(name = "signal_order")
    @Column(name = "signal", nullable = false, length = 500)
    private List<String> signals = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    protected SessionDecisionEntity() {
        // JPA
    }

    public SessionDecisionEntity(
            PlanningSessionEntity session,
            DecisionType decisionType,
            String outcome,
            String rationale,
            List<String> signals
    ) {
        this.id = UUID.randomUUID();
        this.session = session;
        this.decisionType = decisionType;
        this.outcome = outcome;
        this.rationale = rationale;
        this.signals = new ArrayList<>(signals);
    }

    @PrePersist
    void onCreate() {
        this.createdAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public PlanningSessionEntity getSession() {
        return session;
    }

    public DecisionType getDecisionType() {
        return decisionType;
    }

    public String getOutcome() {
        return outcome;
    }

    public String getRationale() {
        return rationale;
    }

    public List<String> getSignals() {
        return List.copyOf(signals);
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
