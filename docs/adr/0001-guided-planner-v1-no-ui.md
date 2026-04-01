# ADR 0001: Guided Planner v1 Without a Dedicated UI

## Status

Accepted

## Context

Arctic Tern is still validating its core workflow. The current problem is not frontend design or agent orchestration. The current problem is whether the system can take messy input, challenge ambiguity, choose the right path, and return a useful structured artifact.

The project has already identified several risks:

- vague user prompts should not immediately produce plans
- not every input is a planning problem
- planning mode selection may need to be deferred
- multi-agent architecture would add complexity before the workflow is proven
- a UI would increase implementation scope before the core interaction is stable

The project is Java 25-first, and the immediate goal is to make the workflow executable and testable with minimal moving parts.

## Decision

Build v1 as a guided planning engine without a dedicated UI.

Use:

- Java 25
- Spring Boot as the application shell
- H2 in file-backed embedded mode for persistence
- JUnit-based scenario tests as the primary way to exercise the workflow

The application will:

- own an explicit workflow state machine
- persist sessions, messages, facts, decisions, and artifacts
- use LLM-backed steps through bounded services with validated structured outputs
- produce typed artifacts such as plans or decision memos

The application will not, in v1:

- ship a dedicated web UI
- depend on a CLI as the primary product surface
- execute autonomous tasks
- introduce multiple autonomous agents

## Consequences

Positive:

- lower implementation complexity
- faster feedback on the core workflow
- clearer architectural boundaries
- easier scenario-based regression testing
- easier evolution of the domain model before a UI locks in assumptions

Negative:

- no real usability validation yet
- interaction quality will be tested through programmatic flows rather than real interface behavior
- some workflow problems may remain hidden until a UI exists

Operational:

- the scenario matrix should become executable JUnit fixtures
- the application core must be designed for testability first
- UI decisions are deferred rather than solved

Follow-up:

- if the workflow proves useful and stable, add a thin UI later on top of the tested application core
- if multi-agent specialization is introduced later, it must remain behind the orchestrator rather than becoming the primary system structure
