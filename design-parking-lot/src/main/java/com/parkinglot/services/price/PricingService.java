package com.parkinglot.services.price;

import com.parkinglot.services.price.model.PricingStrategyType;
import com.parkinglot.services.price.strategy.PricingStrategy;

/**
 * PricingService is responsible for calculating parking fees
 * based on different pricing strategies like FLAT, HOURLY, SLAB, and SURGE.
 */
public class PricingService {

    /**
     * Calculates the parking fee based on the provided pricing strategy and entry/exit times.
     *
     * @param strategyType   the pricing strategy to be used
     * @param entryTimestamp entry time in milliseconds (epoch time)
     * @param exitTimestamp  exit time in milliseconds (epoch time)
     * @return calculated parking fee
     * @throws IllegalArgumentException if entry time is after exit time
     */
    public static double calculatePrice(PricingStrategyType strategyType, long entryTimestamp, long exitTimestamp) {
        if (entryTimestamp > exitTimestamp) {
            throw new IllegalArgumentException("Entry time cannot be after exit time.");
        }

        PricingStrategy strategy = PricingStrategyFactory.getStrategy(strategyType);
        return strategy.calculatePrice(entryTimestamp, exitTimestamp);
    }
}
