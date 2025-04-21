package com.parkinglot.services.price.strategy;

public interface PricingStrategy {
    double calculatePrice(
            long entryTime,
            long exitTime
    );
}
