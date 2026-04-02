package game.arctictern.application;

import game.arctictern.domain.WorkflowState;

import java.time.Instant;
import java.util.UUID;

public record PlanningSessionView(
        UUID id,
        WorkflowState state,
        Instant createdAt,
        Instant updatedAt
) {
}
