# Scenario Matrix

## Purpose

This document pressure-tests the current product principles and planning modes against concrete scenarios.

It is not a final taxonomy. It is a working evaluation tool for finding where the current model is useful, where it is too eager to classify, and where the product still needs better concepts.

Use this document before tightening the v1 spec.

## How To Use This Matrix

For each scenario, test whether the current system can:

1. recognize what is ambiguous
2. ask the right clarifying questions
3. decide whether the input is plan-ready
4. choose a fitting planning mode, if one exists
5. produce the right output artifact
6. avoid fake precision

If a scenario does not fit cleanly, do not force it. Capture the failure and use it to improve the model.

## Scenario Template

Each scenario is evaluated using:

- user type
- raw input
- what is missing
- plan readiness
- likely planning mode
- ideal output artifact
- pressure-test notes

## Scenario 1: Oracle Technical Specialist After Customer Meeting

- User type: Technical customer-facing specialist in Oracle Java
- Raw input: "I met the customer today and I want a better connection with them."
- What is missing:
  - which customer and what type of account
  - what happened in the meeting
  - what "better connection" means
  - who the stakeholders are
  - what follow-through is expected
  - what success would look like in 30 or 90 days
- Plan readiness: Not plan-ready
- Likely planning mode: Unclear at first; could become Outcome Mode once "better connection" is translated into observable customer outcomes or engagement signals
- Ideal output artifact: Account engagement plan with desired outcome, stakeholder map, risks, unknowns, and next actions
- Pressure-test notes:
  - This scenario validates the principle that vague relationship language is not enough input.
  - It also shows that the product may need an account-planning artifact that is not presented as formal OKRs.
  - If the system jumps straight to OKRs here, it will likely invent weak metrics.

## Scenario 2: Oracle Technical Specialist Preparing a Customer Workshop

- User type: Technical customer-facing specialist in Oracle Java
- Raw input: "I need to prepare a workshop for this customer next month."
- What is missing:
  - workshop purpose
  - intended audience
  - desired customer outcome
  - what the customer should know or do afterward
  - constraints on time, format, and content
- Plan readiness: Not plan-ready until the intended outcome is clear
- Likely planning mode: Ambiguous between Outcome Mode and Delivery Mode
- Ideal output artifact: Workshop brief with objective, success criteria, agenda outline, dependencies, and next actions
- Pressure-test notes:
  - This is one of the strongest cases for keeping Delivery Mode somewhere in the model.
  - It also supports the argument that the system should challenge delivery requests before accepting the artifact as the goal.
  - If the user only cares about getting the workshop ready, delivery planning may be enough.

## Scenario 3: Developer Learning a New Web Framework

- User type: Individual developer
- Raw input: "I want to build a web application."
- What is missing:
  - why they want to build it
  - whether the goal is learning, shipping, or testing an idea
  - constraints on time and scope
  - what success would look like
- Plan readiness: Not plan-ready
- Likely planning mode: Cannot classify yet; may become Learning Mode, Outcome Mode, Delivery Mode, or Experiment Mode depending on the clarified intent
- Ideal output artifact: Depends on the clarified goal
- Pressure-test notes:
  - This is the canonical test for clarification-first behavior.
  - It validates that the system should not accept artifact language as a real objective.
  - It also shows that mode selection must sometimes be deferred.

## Scenario 4: Developer Learning Next.js Through a Side Project

- User type: Individual developer
- Raw input: "I want to learn Next.js by building a small web app."
- What is missing:
  - how deep the learning needs to go
  - how much time is available
  - what evidence would prove useful learning
  - what kind of app is sufficient
- Plan readiness: Mostly plan-ready after light clarification
- Likely planning mode: Learning Mode with a delivery artifact
- Ideal output artifact: Learning plan with learning objective, evidence of learning, scope limits, and next steps
- Pressure-test notes:
  - This is a strong example of using OKR-like discipline without forcing formal KRs.
  - It also supports the distinction between intent and execution shape.

## Scenario 5: Founder Wants More Inbound Leads

- User type: Early-stage founder
- Raw input: "I want more inbound leads."
- What is missing:
  - current lead volume and quality
  - ideal customer profile
  - timeframe
  - channels available
  - business constraints
- Plan readiness: Not plan-ready until baseline and target are clarified
- Likely planning mode: Outcome Mode
- Ideal output artifact: Objective, key results, assumptions, risks, and 30-day action plan
- Pressure-test notes:
  - This is a strong fit for formal OKRs.
  - It validates the value of measurable outcomes and baselines.

## Scenario 6: Team Lead Wants Faster Incident Response

- User type: Engineering or operations team lead
- Raw input: "We need better response time."
- What is missing:
  - what type of response time
  - current baseline
  - target threshold
  - root causes
  - owner and timeframe
- Plan readiness: Not plan-ready
- Likely planning mode: Outcome Mode
- Ideal output artifact: Objective, measurable success criteria, key results, risks, and interventions
- Pressure-test notes:
  - Another strong OKR case.
  - This scenario validates that business-like operating goals can sustain tighter metrics.

## Scenario 7: Product Team Testing a New Feature Idea

- User type: Product manager or founder
- Raw input: "I want to test whether users care about an AI summary feature."
- What is missing:
  - target user segment
  - hypothesis
  - what signal would count as evidence
  - test scope
  - decision threshold
- Plan readiness: Mostly plan-ready after light clarification
- Likely planning mode: Experiment Mode
- Ideal output artifact: Hypothesis, experiment design, success and failure signals, and follow-up decision paths
- Pressure-test notes:
  - This scenario validates the need for a mode that is not disguised outcome planning.
  - Forcing OKRs here would likely overstate confidence too early.

## Scenario 8: Salesperson Planning an Account Renewal

- User type: Account executive or salesperson
- Raw input: "I need to renew this account and grow it."
- What is missing:
  - account status
  - renewal risk
  - stakeholders
  - commercial goals
  - obstacles
  - timeframe
- Plan readiness: Not plan-ready
- Likely planning mode: Outcome Mode
- Ideal output artifact: Account plan with objective, success measures, risks, stakeholder gaps, and next actions
- Pressure-test notes:
  - This is closer to standard business OKRs but still benefits from account-specific planning language.
  - It also shows that user-facing OKR jargon may not be necessary even when the internal structure is outcome-oriented.

## Scenario 9: Engineer Evaluating a Platform Decision

- User type: Engineer or architect
- Raw input: "Should we migrate from Java 17 to Java 21?"
- What is missing:
  - business reason for migration
  - constraints and dependencies
  - expected benefits
  - migration risks
  - timeframe
- Plan readiness: Not a planning problem yet
- Likely planning mode: None yet; this is a decision-support case
- Ideal output artifact: Decision memo with criteria, tradeoffs, risks, and recommendation
- Pressure-test notes:
  - This scenario exposes a gap in the current model.
  - Not every useful input is immediately a goal-planning problem.
  - The product may need explicit pre-mode states such as "needs decision support" or "not plan-ready."

## Scenario 10: Manager Says the Team Is Overloaded

- User type: Team manager
- Raw input: "My team is overloaded and we need to fix this."
- What is missing:
  - what overload means
  - evidence of overload
  - whether the problem is staffing, prioritization, process, or tooling
  - timeframe
  - what a better state would look like
- Plan readiness: Not plan-ready
- Likely planning mode: Cannot classify yet; may become Outcome Mode or require diagnosis first
- Ideal output artifact: Problem diagnosis followed by a plan once the real issue is clearer
- Pressure-test notes:
  - This validates that the product must sometimes diagnose before planning.
  - It also challenges the assumption that every pain statement should immediately produce goals.

## Scenario 11: Individual Wants to Get Better at Public Speaking

- User type: Individual professional
- Raw input: "I want to get better at public speaking."
- What is missing:
  - specific situations they care about
  - baseline ability
  - timeframe
  - what better means
  - evidence of progress
- Plan readiness: Not fully plan-ready
- Likely planning mode: Learning Mode
- Ideal output artifact: Learning objective with evidence signals, practice plan, and reflection checkpoints
- Pressure-test notes:
  - This supports the idea that not all valid planning goals are business goals.
  - It also tests whether the system can demand evidence without over-quantifying personal growth.

## Scenario 12: Founder Wants to "Do Something With AI"

- User type: Founder
- Raw input: "I want to do something with AI in the business."
- What is missing:
  - business problem
  - user
  - expected outcome
  - constraints
  - success criteria
  - why AI is relevant
- Plan readiness: Not plan-ready
- Likely planning mode: None yet
- Ideal output artifact: Clarified opportunity framing or a short list of candidate problem statements
- Pressure-test notes:
  - This is a direct test of whether the system can reject trend-driven vagueness.
  - If the system classifies too early here, it will generate polished nonsense.

## Cross-Scenario Findings

The current model appears strongest when:

- the user wants a measurable external change
- a baseline and timeframe can be established
- the system can challenge ambiguity before planning

The current model appears weaker when:

- the user input is really a decision question
- the user is describing pain but not yet a goal
- the artifact is clear but the reason behind it is not
- relationship goals need better proxies before they become measurable

## Open Questions Raised By This Matrix

- Do we need explicit pre-mode states such as "needs clarification," "needs diagnosis," and "needs decision support"?
- Should Delivery Mode remain a top-level planning mode, or should it become an execution pattern that can attach to other modes?
- Should the user-facing product talk about OKRs at all, or keep them as internal planning discipline?
- What output artifact is most useful for Oracle technical customer-facing work: OKR, account plan, workshop brief, or engagement plan?

## Recommendation

Use this matrix to test future prompts and prototype behaviors before writing `docs/v1-spec.md`.

If several scenarios repeatedly break the current model in the same way, revise the model before tightening the spec.
