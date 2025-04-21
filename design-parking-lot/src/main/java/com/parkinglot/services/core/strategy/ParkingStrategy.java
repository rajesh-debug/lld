package com.parkinglot.services.core.strategy;

public interface ParkingStrategy {

    void addSlot(Integer slotNumber);

    void removeSlot(Integer slotNumber);

    int getNextSlot();
}
