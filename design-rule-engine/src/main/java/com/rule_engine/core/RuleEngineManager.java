package com.rule_engine.core;

import com.rule_engine.model.Expression;
import com.rule_engine.model.Outcome;
import com.rule_engine.model.Rule;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RuleEngineManager {

    private final RuleEngineService ruleEngineService;

    public RuleEngineManager(RuleEngineService ruleEngineService) {
        this.ruleEngineService = Objects.requireNonNull(ruleEngineService, "RuleEngineService must not be null");
    }

    public Outcome evaluate(Map<Expression, List<String>> input, List<String> ruleIds) {
        for (String ruleId : ruleIds) {
            Rule rule = ruleEngineService.getRuleById(ruleId);
            if (ruleEngineService.isApplicable(input, rule)) {
                Outcome outcome = ruleEngineService.apply(input, rule);
                if (outcome != null) {
                    return outcome;
                }
            }
        }
        return null;
    }
}
