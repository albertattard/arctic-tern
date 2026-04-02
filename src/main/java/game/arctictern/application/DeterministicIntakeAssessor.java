package game.arctictern.application;

import game.arctictern.domain.IntakeState;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class DeterministicIntakeAssessor implements IntakeAssessor {

    @Override
    public IntakeAssessment assess(String prompt) {
        var normalized = normalize(prompt);
        var signals = new ArrayList<String>();

        if (isDecisionSupport(normalized, signals)) {
            return new IntakeAssessment(
                    IntakeState.NEEDS_DECISION_SUPPORT,
                    "The prompt is framed as a decision question and should be routed to decision support before planning.",
                    signals
            );
        }

        if (isDiagnosis(normalized, signals)) {
            return new IntakeAssessment(
                    IntakeState.NEEDS_DIAGNOSIS,
                    "The prompt describes a problem state without enough clarity on the underlying goal or cause.",
                    signals
            );
        }

        if (isPlanReady(normalized, signals)) {
            return new IntakeAssessment(
                    IntakeState.PLAN_READY,
                    "The prompt has enough intent and success framing to move into planning.",
                    signals
            );
        }

        signals.add("missing context for user, goal, or success criteria");
        return new IntakeAssessment(
                IntakeState.NEEDS_CLARIFICATION,
                "The prompt is too ambiguous to plan against reliably and needs clarification first.",
                signals
        );
    }

    private String normalize(String prompt) {
        return prompt == null ? "" : prompt.trim().toLowerCase(Locale.ROOT);
    }

    private boolean isDecisionSupport(String prompt, List<String> signals) {
        var decisionSignal = prompt.startsWith("should ")
                || prompt.startsWith("should we ")
                || prompt.startsWith("can we ")
                || prompt.contains("migrate from")
                || prompt.endsWith("?");

        if (decisionSignal) {
            signals.add("prompt is phrased as a decision question");
        }

        return decisionSignal;
    }

    private boolean isDiagnosis(String prompt, List<String> signals) {
        var diagnosisSignal = prompt.contains("overloaded")
                || prompt.contains("need to fix this")
                || prompt.contains("something is wrong")
                || prompt.contains("problem with");

        if (diagnosisSignal) {
            signals.add("prompt describes a pain point instead of a clearly framed goal");
        }

        return diagnosisSignal;
    }

    private boolean isPlanReady(String prompt, List<String> signals) {
        var experimentSignal = prompt.contains("test whether");
        var structuredLearningSignal = prompt.contains("learn")
                && (prompt.contains("by building") || prompt.contains("by creating"));

        if (experimentSignal) {
            signals.add("prompt includes an explicit validation intent");
        }

        if (structuredLearningSignal) {
            signals.add("prompt includes a bounded learning goal with an execution shape");
        }

        return experimentSignal || structuredLearningSignal;
    }
}
