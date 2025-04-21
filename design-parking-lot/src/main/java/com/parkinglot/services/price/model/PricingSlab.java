package com.parkinglot.services.price.model;

public class PricingSlab {
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
