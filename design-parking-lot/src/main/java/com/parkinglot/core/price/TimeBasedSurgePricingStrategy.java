package com.parkinglot.core.price;

import com.parkinglot.model.Vehicle;

import java.util.Calendar;
import java.util.Map;

public class TimeBasedSurgePricingStrategy implements PricingStrategy {
    private final double baseRate;
    private final Map<Integer, Double> hourToSurgeMultiplier; // 0-23 → 1.0, 1.5 etc.

    public TimeBasedSurgePricingStrategy(double baseRate, Map<Integer, Double> hourToSurgeMultiplier) {
        this.baseRate = baseRate;
        this.hourToSurgeMultiplier = hourToSurgeMultiplier;
    }

    @Override
    public double calculatePrice(long entryTime, long exitTime, Vehicle vehicle) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(entryTime);
        int entryHour = calendar.get(Calendar.HOUR_OF_DAY);
        double multiplier = hourToSurgeMultiplier.getOrDefault(entryHour, 1.0);

        long hours = Math.max(1, (exitTime - entryTime) / (1000 * 60 * 60));
        return baseRate * hours * multiplier;
    }
}
