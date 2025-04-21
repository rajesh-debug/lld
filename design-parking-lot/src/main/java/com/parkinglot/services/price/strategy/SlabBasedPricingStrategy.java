package com.parkinglot.services.price.strategy;

import com.parkinglot.services.price.model.PricingSlab;

import java.util.List;


public class SlabBasedPricingStrategy implements PricingStrategy {

    private final List<PricingSlab> slabs;
    private final double additionalRatePerHour;

    public SlabBasedPricingStrategy(List<PricingSlab> slabs, double additionalRatePerHour) {
        this.slabs = slabs;
        this.additionalRatePerHour = additionalRatePerHour;
    }

    @Override
    public double calculatePrice(long entryTime, long exitTime) {
        long durationInHours = (exitTime - entryTime) / (1000 * 60 * 60);
        double price = 0;

        for (PricingSlab slab : slabs) {
            if (durationInHours <= slab.getUpToHour()) {
                return slab.getPrice();
            }
            price = slab.getPrice(); // last applicable slab
        }

        long extraHours = durationInHours - slabs.getLast().getUpToHour();
        return price + extraHours * additionalRatePerHour;
    }
}
