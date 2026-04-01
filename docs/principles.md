# Product Principles

## Status

This document captures the current product principles for Arctic Tern.

These are working constraints, not final truths. If a principle no longer survives scrutiny, change it deliberately rather than drifting away from it.

## Product Aim

Arctic Tern should help a user turn a vague intention into a clear, defensible, and actionable plan.

The current working hypothesis is that OKRs may be a useful structure for some of these situations, but OKRs are not the product by default. They are one tool the product may use when they fit the problem.

## Core Product Beliefs

- The hard problem is not text generation. The hard problem is clarification, critique, prioritization, and translation into measurable commitments.
- The product should create discipline, not just polished wording.
- The system should improve decision quality, not merely accelerate output.
- A vague goal should not be treated as sufficient input.
- If the right answer is "this should not be an OKR," the system should say so.

## User Input Principles

The product should expect messy, incomplete input from the user.

The system must not silently invent critical business context. It should force clarification when important details are missing.

Relevant clarification dimensions may include:

- who the user is
- what they want to achieve
- why it matters
- what constraints apply
- what success looks like
- what timeframe applies
- what baseline exists today
- what information is still unknown

## Output Principles

A useful output should be:

- specific enough to act on
- explicit about assumptions
- measurable where measurement is appropriate
- realistic within the stated constraints
- narrow enough to guide action rather than create false certainty

If the output depends on guessed context, the guesses must be surfaced clearly.

## OKR Principles

Use OKRs when they help the user move from vague ambition to measurable outcomes.

Do not force every problem into an OKR structure.

A credible objective should be:

- clear
- outcome-oriented
- relevant to the user's stated context

A credible key result should be:

- measurable
- time-bound
- meaningfully connected to the objective
- realistically influenceable by the user or team
- tied to a known baseline or an explicit assumption

Reject vanity metrics and vague key results.

## Planning Versus Execution

The product should clearly separate:

- problem clarification
- goal and success definition
- planning
- implementation support
- autonomous execution

Default to recommendation and planning unless the user explicitly wants execution support and the trust boundary is clear.

## Scope Principles

Do not optimize for breadth too early.

It is better to work well for a narrow user and problem type than to be generically plausible for everyone.

Treat the following as unresolved until explicitly decided:

- primary user
- initial domain
- whether OKRs are central or optional
- whether the product only recommends or also acts

## System Design Principles

Do not treat "multi-agent" as the goal.

Start with the simplest system that can produce high-quality outputs consistently. Add agent specialization only when it improves quality, control, or evaluation.

Architecture should follow validated workflow, not the other way around.

## Evaluation Principles

The product should be judged on whether it produces better decisions and clearer plans, not on whether its language sounds impressive.

Evaluation should prioritize:

- clarity
- validity
- measurability
- usefulness
- feasibility
- resistance to vague or contradictory input

## Current Non-Goals

The following are not starting points unless deliberately chosen later:

- broad autonomous action across external systems
- generic "AI for everything" positioning
- integrations that distract from proving the core planning workflow
- agent complexity added for its own sake
