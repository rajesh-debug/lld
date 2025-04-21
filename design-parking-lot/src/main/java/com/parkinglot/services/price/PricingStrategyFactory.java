package com.parkinglot.services.price;

import com.parkinglot.services.price.model.PricingSlab;
import com.parkinglot.services.price.model.PricingStrategyType;
import com.parkinglot.services.price.strategy.*;

import java.util.List;
import java.util.Map;


public class PricingStrategyFactory {

    private static final Map<Integer, Double> hourToSurgeMultipliers = Map.of(
            0, 1.0,  // 12 AM
            1, 1.2,
            2, 1.1,
            8, 1.5,  // morning rush hour
            9, 1.8,
            17, 2.0, // evening peak
            18, 2.0,
            19, 1.7,
            23, 1.3
    );

    private static final List<PricingSlab> pricingSlabs = List.of(
            new PricingSlab(1, 20),
            new PricingSlab(3, 50)
    );

    private static final Map<PricingStrategyType, PricingStrategy> pricingMap = Map.of(
            PricingStrategyType.FLAT, new FlatRatePricingStrategy(100),
            PricingStrategyType.HOURLY, new HourlyPricingStrategy(25),
            PricingStrategyType.SURGE, new TimeBasedSurgePricingStrategy(40, hourToSurgeMultipliers),
            PricingStrategyType.SLAB, new SlabBasedPricingStrategy(pricingSlabs, 30)
    );

    public static PricingStrategy getStrategy(PricingStrategyType type) {
        PricingStrategy pricingStrategy = pricingMap.get(type);
        if (pricingStrategy == null) {
            throw new IllegalArgumentException("No PricingStrategy found for type " + type);
        }

        return pricingStrategy;
    }
}