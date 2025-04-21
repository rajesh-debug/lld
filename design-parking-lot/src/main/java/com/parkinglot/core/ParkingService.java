package com.parkinglot.core;

import com.parkinglot.core.exception.ParkingLotConflictException;
import com.parkinglot.core.exception.SlotFullException;
import com.parkinglot.core.strategy.NaturalSortingParkingStrategy;
import com.parkinglot.core.strategy.ParkingStrategy;
import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.Vehicle;

public class ParkingService {

    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy = new NaturalSortingParkingStrategy();

    public void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        if (this.parkingLot != null) {
            throw new ParkingLotConflictException("ParkingLot already exists");
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        for (int i = 0; i <= parkingLot.getCapacity(); i++) {
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

    public Integer unpark(int slotNumber) {

        parkingLot.unparkVehicle(slotNumber);

        // remove from available slot
        parkingStrategy.addSlot(slotNumber);

        return slotNumber;
    }


    private void validateParkingLotAvailable() {
        if (parkingLot == null) {
            throw new SlotFullException("ParkingLot capacity exceeded");
        }
    }
}

