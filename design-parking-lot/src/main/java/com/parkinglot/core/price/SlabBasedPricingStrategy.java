package com.parkinglot.core.price;

import com.parkinglot.model.Vehicle;

public class SlabBasedPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(long entryTime, long exitTime, Vehicle vehicle) {
        long durationInHours = (exitTime - entryTime) / (1000 * 60 * 60);
        if (durationInHours <= 1) return 20;
        if (durationInHours <= 3) return 50;
        return 50 + (durationInHours - 3) * 30;
    }
}
