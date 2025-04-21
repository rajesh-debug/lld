package com.parkinglot.services.price.strategy;

public class HourlyPricingStrategy implements PricingStrategy {
    private final double hourlyRate;

    public HourlyPricingStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePrice(long entryTime, long exitTime) {
        long durationInHours = (exitTime - entryTime) / (1000 * 60 * 60);
        return Math.max(1, durationInHours) * hourlyRate;
    }
}
