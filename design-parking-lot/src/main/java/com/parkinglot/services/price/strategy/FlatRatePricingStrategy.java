package com.parkinglot.services.price.strategy;

public class FlatRatePricingStrategy implements PricingStrategy {
    private final double rate;

    public FlatRatePricingStrategy(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculatePrice(long entryTime, long exitTime) {
        return rate;
    }
}
