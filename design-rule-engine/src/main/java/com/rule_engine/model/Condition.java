package com.rule_engine.model;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Condition {
    private final Expression expression;
    private final Operation operation;
    private final List<String> values;

    public Condition(Expression expression, Operation operation, List<String> values) {
        this.expression = expression;
        this.operation = operation;
        this.values = values;
    }

    public boolean isApplicable(Map<Expression, List<String>> input) {
        List<String> inputValues = input.get(expression);
        return switch (operation) {
            case INCLUDES -> inputValues != null && new HashSet<>(inputValues).containsAll(values);
            case EXCLUDES -> inputValues == null || values.stream().noneMatch(inputValues::contains);
        };
    }
}

