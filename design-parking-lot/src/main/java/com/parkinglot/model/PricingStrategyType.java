package com.parkinglot.model;

public enum PricingStrategyType {
    FLAT("flat"),
    HOURLY("hourly"),
    SURGE("surge"),
    SLAB("slab");

    private final String type;

    PricingStrategyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}