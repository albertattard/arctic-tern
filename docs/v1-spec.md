# V1 Spec

## Status

This is a working v1 specification. It is intentionally narrow and expected to evolve.

## Goal

Build a Java 25 application that takes messy user input, determines whether it is ready for planning, guides clarification when needed, and produces a structured planning artifact.

## Primary User

Initial use is internal dogfooding by the project author and similar technical customer-facing specialists in Oracle Java.

This is not yet a general-purpose product for all users.

## Problem

Users often start with vague or poorly formed goals. A generic LLM can generate polished text, but it does not reliably:

- force clarification
- reject weak assumptions
- distinguish planning from diagnosis or decision support
- choose an appropriate planning structure
- return a structured artifact that can be inspected and revised

## Non-Goals

V1 will not:

- ship a dedicated UI
- execute autonomous tasks
- integrate with email, CRM, or external systems
- optimize for broad market coverage
- depend on multi-agent behavior

## Inputs

V1 accepts:

- a raw user prompt
- optional follow-up answers during clarification

Example raw prompts:

- "I met the customer today and I want a better connection with them."
- "I want to build a web application."
- "I want to test whether users care about this feature."

## Core Workflow

V1 should support this flow:

1. Accept raw input.
2. Assess whether the request needs clarification, diagnosis, decision support, or is ready for planning.
3. Ask targeted follow-up questions when needed.
4. Select a planning mode only when justified.
5. Draft a structured artifact.
6. Critique and revise the artifact.
7. Return the final artifact with assumptions, risks, and next actions.

## Required Workflow States

The application should support at least these states:

- `intake`
- `needs_clarification`
- `needs_diagnosis`
- `needs_decision_support`
- `plan_ready`
- `drafting`
- `critiquing`
- `finalized`

## Planning Modes

The current planning modes are:

- `outcome`
- `learning`
- `delivery`
- `experiment`

Mode selection is provisional. The system must be allowed to return "not yet classifiable" and continue clarification or diagnosis.

## Outputs

V1 should return structured artifacts, not only prose.

Expected artifact families:

- outcome plan
- learning plan
- delivery plan
- experiment plan
- decision memo

Each artifact should include:

- summary
- assumptions
- risks
- next actions

## Persistence

Persist at least:

- sessions
- user and system messages
- extracted facts
- intermediate decisions
- final artifacts

## Testing Approach

V1 will be exercised primarily through JUnit tests.

The tests should:

- create or resume a session
- submit prompts and follow-up answers
- advance the workflow
- assert state transitions
- assert selected mode or lack of mode
- assert artifact family
- assert banned failure patterns where possible

The current [scenario matrix](scenario-matrix.md) should be converted into executable test fixtures over time.

## Success Criteria

V1 is successful if:

- vague prompts do not immediately produce confident plans
- the system asks targeted clarification questions
- the system can distinguish planning from decision support and diagnosis
- the system can return a structured artifact for plan-ready cases
- the workflow is testable and repeatable through JUnit

## Open Questions

- Should `delivery` remain a top-level planning mode?
- Should diagnosis become its own artifact type?
- What should be the first primary artifact for Oracle technical users?
- When the workflow stabilizes, should the first real interface be CLI or web?
