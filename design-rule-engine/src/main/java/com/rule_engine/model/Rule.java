package com.rule_engine.model;

import java.util.List;
import java.util.Map;

public class Rule {
    private final String id;
    private final Operator operator;
    private final List<Condition> conditions;
    private final Outcome outcome;

    public Rule(String id, Operator operator, List<Condition> conditions, Outcome outcome) {
        this.id = id;
        this.operator = operator;
        this.conditions = conditions;
        this.outcome = outcome;
    }

    public boolean isApplicable(Map<Expression, List<String>> input) {
        return switch (operator) {
            case AND -> conditions.stream().allMatch(condition -> condition.isApplicable(input));
            case OR -> conditions.stream().anyMatch(condition -> condition.isApplicable(input));
            case NOT -> false;
        };
    }

    public Outcome getOutcome() {
        return outcome;
    }
}
