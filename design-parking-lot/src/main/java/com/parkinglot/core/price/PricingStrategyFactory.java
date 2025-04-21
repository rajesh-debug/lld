package com.parkinglot.core.price;// PricingStrategyFactory.java

import java.util.List;
import java.util.Map;

public class PricingStrategyFactory {

    private static final Map<Integer, Double> hourToSurgeMultipliers = Map.of(
            0, 1.2,  // 12 AM
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


    private static final Map<String, PricingStrategy> pricingMap = Map.of(
            "flat", new FlatRatePricingStrategy(50),
            "hourly", new HourlyPricingStrategy(30),
            "surge", new TimeBasedSurgePricingStrategy(40, hourToSurgeMultipliers),
            "slab", new SlabBasedPricingStrategy(pricingSlabs, 30)
    );

    public static PricingStrategy getStrategy(String type) {
        return pricingMap.getOrDefault(type, new FlatRatePricingStrategy(50)); // fallback
    }
}
