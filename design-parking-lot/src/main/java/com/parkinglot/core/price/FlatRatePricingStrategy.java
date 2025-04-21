package com.parkinglot.core.price;

import com.parkinglot.model.Vehicle;

public class FlatRatePricingStrategy implements PricingStrategy {
    private final double rate;

    public FlatRatePricingStrategy(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculatePrice(long entryTime, long exitTime, Vehicle vehicle) {
        return rate;
    }
}
