package game.arctictern.domain;

public enum WorkflowState {
    INTAKE,
    NEEDS_CLARIFICATION,
    NEEDS_DIAGNOSIS,
    NEEDS_DECISION_SUPPORT,
    PLAN_READY,
    DRAFTING,
    CRITIQUING,
    FINALIZED;

    public static WorkflowState fromIntakeState(IntakeState intakeState) {
        return switch (intakeState) {
            case NEEDS_CLARIFICATION -> NEEDS_CLARIFICATION;
            case NEEDS_DIAGNOSIS -> NEEDS_DIAGNOSIS;
            case NEEDS_DECISION_SUPPORT -> NEEDS_DECISION_SUPPORT;
            case PLAN_READY -> PLAN_READY;
        };
    }
}
