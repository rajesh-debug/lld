package com.parkinglot.model;

import lombok.Getter;

@Getter
public class Slot {

    private Vehicle vehicle;
    private final Integer number;
    private Long entryTime;

    public Slot(Integer number) {
        this.number = number;
    }

    public Slot(Vehicle vehicle, Integer number) {
        this.vehicle = vehicle;
        this.number = number;
        this.entryTime = System.currentTimeMillis();
    }

    /**
     * Checks whether the slot is occupied.
     *
     * @return true if a vehicle is parked, false otherwise
     */
    public boolean isOccupied() {
        return vehicle != null;
    }

    /**
     * Assigns a vehicle to this slot.
     *
     * @param vehicle the vehicle to park in this slot
     */
    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Unassigns the currently parked vehicle from this slot.
     */
    public void clear() {
        this.vehicle = null;
    }

    @Override
    public String toString() {
        if (isOccupied()) {
            return String.format(
                    "{ Slot number=%d, occupied=true, vehicle=%s, color=%s }",
                    number,
                    vehicle.licensePlateNumber(),
                    vehicle.color()
            );
        } else {
            return String.format(
                    "{ Slot number=%d, occupied=false }",
                    number
            );
        }
    }

    public Long getExitTime() {
        return System.currentTimeMillis();
    }
}