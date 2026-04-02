# SPEC-001: Guided Planner Workflow

- Status: Proposed
- Owner: @aattard
- Created: 2026-04-02
- Last updated: 2026-04-02

## Problem

Users often begin with vague, incomplete, or poorly framed goals. A generic LLM can generate polished text, but it does not reliably force clarification, distinguish planning from diagnosis or decision support, or return a structured artifact that can be inspected and revised.

## Goals

- Accept messy user input as the starting point.
- Determine whether the request needs clarification, diagnosis, decision support, or is ready for planning.
- Ask targeted follow-up questions when needed.
- Select a planning mode only when justified.
- Return a structured artifact rather than only free-form prose.
- Make the workflow testable through repeatable JUnit scenarios.

## Non-goals

- Shipping a dedicated UI in v1.
- Executing autonomous tasks.
- Integrating with email, CRM, or external systems in v1.
- Depending on multi-agent behavior in v1.
- Optimizing for broad market coverage before the workflow is proven.

## Primary User

Initial use is internal dogfooding by the project author and similar technical customer-facing specialists in Oracle Java.

This is not yet a general-purpose product for all users.

## Inputs

The system accepts:

- a raw user prompt
- optional follow-up answers during clarification

Example raw prompts:

- "I met the customer today and I want a better connection with them."
- "I want to build a web application."
- "I want to test whether users care about this feature."

## User-visible Behavior

- The system accepts a raw prompt and does not assume it is immediately ready for planning.
- The system assesses whether the request needs clarification, diagnosis, decision support, or planning.
- When clarification is needed, the system asks targeted follow-up questions rather than drafting a plan immediately.
- The system may refuse to choose a planning mode when the input is still too ambiguous.
- When the request is ready, the system drafts a structured artifact and then critiques and revises it before finalizing.
- The system returns the final artifact with assumptions, risks, and next actions.

## Workflow States

The workflow should support at least these states:

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

The system should return structured artifacts, not only prose.

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

## Persistence Expectations

The implementation should persist at least:

- sessions
- user and system messages
- extracted facts
- intermediate decisions
- final artifacts

## Acceptance Criteria

- [ ] Given a vague prompt such as "I want to build a web application," the system does not immediately produce a confident final plan.
- [ ] Given an ambiguous prompt, the system asks targeted clarification questions before selecting a planning mode.
- [ ] Given a prompt that is really a decision question, the system can route to decision support instead of pretending it is ready for planning.
- [ ] Given a prompt that is plan-ready after clarification, the system returns a structured artifact with assumptions, risks, and next actions.
- [ ] Given a session exercised through JUnit, the workflow state transitions are repeatable and inspectable.

## Open Questions

- Should `delivery` remain a top-level planning mode?
- Should diagnosis become its own artifact type?
- What should be the first primary artifact for Oracle technical users?
- When the workflow stabilizes, should the first real interface be CLI or web?
