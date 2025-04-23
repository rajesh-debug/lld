package com.rule_engine.core;

import com.rule_engine.model.Expression;
import com.rule_engine.model.Outcome;
import com.rule_engine.model.Rule;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Responsible for orchestrating rule evaluation and determining outcomes.
 */
public class RuleEngineManager {

    private final RuleEngineService ruleEngineService;

    public RuleEngineManager(RuleEngineService ruleEngineService) {
        this.ruleEngineService = Objects.requireNonNull(ruleEngineService, "RuleEngineService must not be null");
    }

    /**
     * Evaluates rules in order and returns the outcome of the first applicable rule.
     *
     * @param input    the input data to be evaluated against rules
     * @param ruleIds  a list of rule IDs in priority order
     * @return the outcome of the first applicable rule, or null if none apply
     */
    public Outcome evaluate(Map<Expression, List<String>> input, List<String> ruleIds) {
        for (String ruleId : ruleIds) {
            Rule rule = ruleEngineService.getRuleById(ruleId);
            if (rule != null && ruleEngineService.isApplicable(input, rule)) {
                Outcome outcome = ruleEngineService.apply(input, rule);
                if (outcome != null) {
                    return outcome;
                }
            }
        }
        return null;
    }
}
