package com.parkinglot.services.core.model;

import com.parkinglot.services.exception.SlotFullException;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ParkingLot {

    private static final int MAX_CAPACITY = 100000;

    private final int capacity;
    private final Map<Integer, Slot> slots;

    public ParkingLot(int capacity) {
        if (capacity > MAX_CAPACITY || capacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity given for parking lot.");
        }

        this.capacity = capacity;
        this.slots = new HashMap<>();
    }

    private Slot getSlot(int slotNumber) {
        if (slotNumber > capacity) {
            throw new IllegalArgumentException("Invalid slot number given for parking lot.");
        }
        if (!slots.containsKey(slotNumber)) {
            this.slots.put(slotNumber, new Slot(slotNumber));
        }
        return slots.get(slotNumber);
    }

    public void parkVehicle(Vehicle vehicle, int slotNumber) {
        Slot slot = getSlot(slotNumber);

        if (slot.isOccupied()) {
            throw new SlotFullException("Slot is already occupied.");
        }
        slot.assignVehicle(vehicle);
    }

    public Slot unparkVehicle(int slotNumber) {
        Slot slot = getSlot(slotNumber);
        slot.clear();
        return slot;
    }
}
