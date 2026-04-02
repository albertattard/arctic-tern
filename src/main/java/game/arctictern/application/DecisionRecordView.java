package game.arctictern.application;

import game.arctictern.domain.DecisionType;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record DecisionRecordView(
        UUID id,
        DecisionType decisionType,
        String outcome,
        String rationale,
        List<String> signals,
        Instant createdAt
) {
}
