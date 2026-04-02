---
id: TASK-001
title: Implement Guided Planner Session Core
status: proposed
category: workflow
related_features:
  - SPEC-001
owner: @aattard
created: 2026-04-02
updated: 2026-04-02
---

## Summary

Implement the first bounded slice of the guided planner: session creation, workflow state ownership, and enough orchestration to assess raw input and move a session into the correct next state.

## Scope

- Create the initial Java 25 project structure.
- Implement session creation and persistence.
- Implement workflow state persistence.
- Implement the intake assessment boundary.
- Support transitions into:
  - `needs_clarification`
  - `needs_diagnosis`
  - `needs_decision_support`
  - `plan_ready`
- Add JUnit tests that exercise these transitions using representative scenarios.

## Assumptions

- LLM-backed behavior may initially be stubbed or simplified if needed to prove the orchestration boundary.
- This task does not need to produce a final plan artifact yet.
- This task is about workflow control, not frontend interaction.

## Acceptance Criteria

- [ ] A new session can be created and persisted.
- [ ] A raw prompt can be attached to a session and processed through an intake step.
- [ ] The application records one of the expected next states after intake assessment.
- [ ] JUnit tests cover at least one clarification case, one decision-support case, and one plan-ready case.
- [ ] The implementation structure leaves room for later planning, critique, and artifact generation steps without rewriting the session core.

## Notes

This task is intentionally narrower than full planning. It exists to prove the workflow boundary before drafting, critique, and artifact generation are added.
