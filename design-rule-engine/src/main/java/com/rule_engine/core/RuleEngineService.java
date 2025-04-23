package com.rule_engine.core;

import com.rule_engine.model.Expression;
import com.rule_engine.model.Outcome;
import com.rule_engine.model.Rule;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RuleEngineService {

    private final Map<String, Rule> ruleEngineMap;

    public RuleEngineService(Map<String, Rule> ruleEngineMap) {
        this.ruleEngineMap = Objects.requireNonNull(ruleEngineMap, "Rule engine map cannot be null");
    }

    /**
     * Retrieves a cached rule by its ID.
     */
    public Rule getRuleById(String ruleId) {
        Rule rule = ruleEngineMap.get(ruleId);
        if (rule == null) {
            throw new IllegalArgumentException("No rule found for ID: " + rule.getRuleId());
        }
        return rule;
    }

    /**
     * Checks if the rule with the given ID is applicable for the provided input.
     */
    public boolean isApplicable(Map<Expression, List<String>> input, Rule rule) {
        return rule.isApplicable(input);
    }

    /**
     * Applies a rule to the given input string. Implementation to be defined.
     */
    public Outcome apply(Map<Expression, List<String>> input, Rule rule) {
        if (rule == null) {
            throw new IllegalArgumentException("Rule must not be null");
        }
        return rule.getOutcome(); // Assumes Rule has a getResult() method that returns a String
    }

}
