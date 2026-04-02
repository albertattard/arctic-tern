package game.arctictern.application;

import game.arctictern.domain.IntakeState;

import java.util.List;

public record IntakeAssessment(
        IntakeState nextState,
        String rationale,
        List<String> signals
) {
}
