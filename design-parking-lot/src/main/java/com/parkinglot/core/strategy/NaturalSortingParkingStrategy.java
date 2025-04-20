package com.parkinglot.core.strategy;

import com.parkinglot.core.exception.SlotFullException;

import java.util.TreeSet;

public class NaturalSortingParkingStrategy implements ParkingStrategy {

    TreeSet<Integer> slotTreeSet;

    public NaturalSortingParkingStrategy() {
        this.slotTreeSet = new TreeSet<>();
    }

    public void addSlot(Integer slotNumber) {
        this.slotTreeSet.add(slotNumber);
    }

    public void removeSlot(Integer slotNumber) {
        this.slotTreeSet.remove(slotNumber);
    }

    public int getNextSlot() {
        if (this.slotTreeSet.isEmpty()) {
            throw new SlotFullException("No slots available");
        }

        return this.slotTreeSet.last();
    }
}
