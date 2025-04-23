package com.rule_engine.model;

public class Expression {
    private final String key;

    public Expression(String key) {
        this.key = key;
    }

    // equals and hashCode based on 'key' for proper Map usage
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expression that)) return false;
        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}

