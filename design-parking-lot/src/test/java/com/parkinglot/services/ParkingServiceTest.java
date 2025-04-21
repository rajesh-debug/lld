package com.parkinglot.services;

import com.parkinglot.services.core.ParkingService;
import com.parkinglot.services.core.model.Car;
import com.parkinglot.services.core.model.ParkingLot;
import com.parkinglot.services.core.model.Slot;
import com.parkinglot.services.core.strategy.NaturalSortingParkingStrategy;
import com.parkinglot.services.exception.ParkingLotConflictException;
import com.parkinglot.services.exception.SlotFullException;

public class ParkingServiceTest {

    public static void main(String[] args) {
        testParkingService();
    }

    private static void testParkingService() {
        ParkingService service = new ParkingService();
        ParkingLot lot = new ParkingLot(3); // assuming constructor takes capacity
        NaturalSortingParkingStrategy strategy = new NaturalSortingParkingStrategy();

        // Test: create parking lot
        try {
            service.createParkingLot(lot, strategy);
            System.out.println("Test Passed: Parking lot created successfully with capacity " + lot.getCapacity());
        } catch (Exception e) {
            System.out.println("Test Failed: Error creating parking lot - " + e.getMessage());
        }

        // Test: parking a vehicle
        try {
            Car vehicle1 = new Car("KA01AB1234", "white");
            int slot = service.park(vehicle1);
            System.out.println("Test Passed: Vehicle " + vehicle1.licensePlateNumber() +
                    " (" + vehicle1.getColor() + ") parked at slot " + slot);
        } catch (Exception e) {
            System.out.println("Test Failed: Error parking vehicle - " + e.getMessage());
        }

        // Test: parking another vehicle
        try {
            Car vehicle2 = new Car("KA01AB9999", "blue");
            int slot = service.park(vehicle2);
            System.out.println("Test Passed: Vehicle " + vehicle2.licensePlateNumber() +
                    " (" + vehicle2.getColor() + ") parked at slot " + slot);
        } catch (Exception e) {
            System.out.println("Test Failed: Error parking second vehicle - " + e.getMessage());
        }

        // Test: unparking a vehicle
        try {
            Slot slot = service.unpark(2); // assuming slot starts from 1
            System.out.println("Test Passed: Vehicle unparked from slot " + slot);
        } catch (Exception e) {
            System.out.println("Test Failed: Error unparking vehicle - " + e.getMessage());
        }

        // Test: park again after unpark
        try {
            Car vehicle3 = new Car("KA05CD4321", "black");
            int slot = service.park(vehicle3);
            System.out.println("Test Passed: Vehicle " + vehicle3.licensePlateNumber() +
                    " (" + vehicle3.getColor() + ") parked at slot " + slot + " after freeing up a slot.");
        } catch (Exception e) {
            System.out.println("Test Failed: Error parking third vehicle - " + e.getMessage());
        }

        // Test: creating another parking lot (should fail)
        try {
            service.createParkingLot(new ParkingLot(2), new NaturalSortingParkingStrategy());
            System.out.println("Test Failed: Should not allow creating another parking lot.");
        } catch (ParkingLotConflictException e) {
            System.out.println("Test Passed: Duplicate parking lot creation blocked.");
        }

        // Test: Parking without initializing (simulate fresh service)
        try {
            ParkingService newService = new ParkingService();
            newService.park(new Car("KA01XY1234", "red"));
            System.out.println("Test Failed: Should not allow parking before creating lot.");
        } catch (SlotFullException e) {
            System.out.println("Test Passed: Parking before initialization blocked.");
        }
    }
}
