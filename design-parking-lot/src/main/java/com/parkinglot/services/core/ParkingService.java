package com.parkinglot.services.core;

import com.parkinglot.services.core.model.ParkingLot;
import com.parkinglot.services.core.model.Slot;
import com.parkinglot.services.core.model.Vehicle;
import com.parkinglot.services.core.strategy.NaturalSortingParkingStrategy;
import com.parkinglot.services.core.strategy.ParkingStrategy;
import com.parkinglot.services.exception.ParkingLotConflictException;
import com.parkinglot.services.exception.SlotFullException;

public class ParkingService {

    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy = new NaturalSortingParkingStrategy();

    public void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        if (this.parkingLot != null) {
            throw new ParkingLotConflictException("ParkingLot already exists");
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            parkingStrategy.addSlot(i);
        }
    }

    public Integer park(Vehicle vehicle) {
        validateParkingLotAvailable();
        int slotNumber = parkingStrategy.getNextSlot();

        parkingLot.parkVehicle(vehicle, slotNumber);

        // remove from available slot
        parkingStrategy.removeSlot(slotNumber);

        return slotNumber;
    }

    public Slot unpark(int slotNumber) {

        Slot slot = parkingLot.unparkVehicle(slotNumber);
        // remove from available slot
        parkingStrategy.addSlot(slotNumber);

        return slot;
    }


    private void validateParkingLotAvailable() {
        if (parkingLot == null) {
            throw new SlotFullException("ParkingLot capacity exceeded");
        }
    }
}

