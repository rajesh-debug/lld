package com.parkinglot.core.price;

import com.parkinglot.model.Vehicle;

public interface PricingStrategy {
    double calculatePrice(
            long entryTime,
            long exitTime,
            Vehicle vehicle
    );
}
