package com.parkinglot.core.price;

import com.parkinglot.model.Vehicle;

import java.util.List;

class PricingSlab {
    private final int upToHour;
    private final double price;

    public PricingSlab(int upToHour, double price) {
        this.upToHour = upToHour;
        this.price = price;
    }

    public int getUpToHour() {
        return upToHour;
    }

    public double getPrice() {
        return price;
    }
}


public class SlabBasedPricingStrategy implements PricingStrategy {

    private final List<PricingSlab> slabs;
    private final double additionalRatePerHour;

    public SlabBasedPricingStrategy(List<PricingSlab> slabs, double additionalRatePerHour) {
        this.slabs = slabs;
        this.additionalRatePerHour = additionalRatePerHour;
    }

    @Override
    public double calculatePrice(long entryTime, long exitTime, Vehicle vehicle) {
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
