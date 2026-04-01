# Planning Modes

## Purpose

This document defines how Arctic Tern should choose an appropriate planning structure for a user's goal.

The system may use OKR discipline broadly, but it should not force every goal into a formal OKR. Different types of goals require different planning modes.

## Core Principle

The first question is not "what are the OKRs?"

The first question is "what kind of goal is this?"

Before producing a plan, classify the user's intent into the most appropriate planning mode.

## Planning Modes

### 1. Outcome Mode

Use this when the user wants to create a measurable change in a business or operational result.

Typical signals:

- increase, reduce, improve, grow, retain, convert, renew
- references to customers, pipeline, revenue, adoption, usage, response times, engagement
- success can be observed through a clear change in a metric or behavior

Recommended structure:

- objective
- key results
- assumptions
- risks
- 30-day action plan

This is the strongest fit for formal OKRs.

### 2. Learning Mode

Use this when the user's main goal is to understand something, build capability, or become able to make a better decision.

Typical signals:

- learn, explore, understand, evaluate, compare, experiment with
- the user is trying a technology, domain, method, or tool
- the goal is improved judgment rather than immediate business impact

Recommended structure:

- learning objective
- evidence of learning
- decision criteria
- scope and constraints
- next learning steps

Do not force strict business-style KRs here. Require observable evidence instead.

Examples of acceptable evidence:

- build a working prototype
- explain the tradeoffs clearly
- document when the technology should and should not be used
- complete a bounded exercise and reflect on the result

### 3. Delivery Mode

Use this when the user's main goal is to produce or ship a thing.

Typical signals:

- build, ship, deliver, launch, implement, create
- the user already knows what they want to make
- the challenge is execution, sequencing, or scope control

Recommended structure:

- delivery goal
- milestones
- acceptance criteria
- dependencies
- risks
- next actions

Do not disguise a delivery plan as an outcome plan unless the user also has a measurable external result in mind.

### 4. Experiment Mode

Use this when the user is primarily trying to reduce uncertainty or validate an idea.

Typical signals:

- test, validate, check whether, see if, prove, disprove
- the user is unsure whether an idea, workflow, feature, or technology is worth pursuing
- the key value is learning from feedback or evidence

Recommended structure:

- hypothesis
- test design
- success and failure signals
- decision threshold
- follow-up actions

This mode is better than OKRs when the main unknown is whether the idea should move forward at all.

## Mode Selection Rules

Choose the mode based on the dominant intent, not the wording of the first sentence.

Examples:

- "I want to build a website" is not enough to classify.
- "I want to learn this framework by building a small website" suggests Learning Mode with a delivery artifact.
- "I want to launch a website to generate leads" suggests Outcome Mode with a delivery component.
- "I want to test whether users care about this product idea" suggests Experiment Mode.

If multiple modes apply, choose one primary mode and optionally include a secondary mode.

## OKR Fitness Test

Formal OKRs are a good fit when most of the following are true:

- the goal is primarily outcome-oriented
- success can be measured credibly
- the timeframe is clear
- the user or team can influence the result
- the goal benefits from tracking progress over time

Formal OKRs are a weak fit when most of the following are true:

- the goal is mostly exploratory
- the main value is learning or evaluation
- success depends on subjective self-assessment alone
- the user is still deciding what to build
- the real problem is lack of problem clarity rather than lack of metrics

## Evidence Standard

Every mode still needs evidence.

The evidence does not always need to be a business metric, but it must be observable and challengeable.

Weak evidence:

- "I feel like I understand it now"
- "This seems better"
- "I think this worked"

Stronger evidence:

- a prototype works against defined criteria
- tradeoffs are documented clearly
- a decision can be defended with examples
- users responded in a measurable way
- a target behavior changed over time

## Output Strategy

The system should:

1. classify the goal into a planning mode
2. explain the choice briefly
3. use the structure that fits that mode
4. make assumptions explicit
5. challenge weak success criteria before finalizing the plan

## Design Implication

Arctic Tern should not present itself as "an OKR generator."

It should present itself as a system that helps users move from vague intent to a structured plan, using OKRs when OKRs are the right tool.
