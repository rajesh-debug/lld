package com.rule_engine.core;

import com.rule_engine.model.Expression;
import com.rule_engine.model.Outcome;
import com.rule_engine.model.Rule;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RuleEngineService {

    private final Map<String, Rule> rulesById;

    public RuleEngineService(Map<String, Rule> rulesById) {
        this.rulesById = Objects.requireNonNull(rulesById, "Rule map must not be null");
    }

    public Rule getRuleById(String ruleId) {
        return rulesById.get(ruleId);
    }

    public boolean isApplicable(Map<Expression, List<String>> input, Rule rule) {
        return rule != null && rule.isApplicable(input);
    }

    public Outcome apply(Map<Expression, List<String>> input, Rule rule) {
        if (rule == null) {
            throw new IllegalArgumentException("Rule must not be null");
        }

        if (rule.isApplicable(input)) {
            return rule.getOutcome();
        }

        return null;
    }
}

