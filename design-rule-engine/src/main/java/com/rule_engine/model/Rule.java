package com.rule_engine.model;

import java.util.List;
import java.util.Map;


public class Rule {

    private final String ruleId;

    private final Operator operator;

    private final List<Condition> conditions;

    private final Outcome outcome;

    public Rule(String ruleId, Operator operator, List<Condition> conditions, Outcome outcome) {
        this.ruleId = ruleId;
        this.operator = operator;
        this.conditions = conditions;
        this.outcome = outcome;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public String getRuleId() {
        return ruleId;
    }

    public boolean isApplicable(Map<Expression, List<String>> input) {
        List<Condition> conditions = getConditions();

        return switch (operator) {
            case AND -> conditions.stream().allMatch(condition -> condition.isApplicable(input));
            case OR -> conditions.stream().anyMatch(condition -> condition.isApplicable(input));
            default -> false;
        };
    }
}
