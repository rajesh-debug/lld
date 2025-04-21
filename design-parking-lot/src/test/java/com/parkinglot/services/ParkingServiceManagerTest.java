package com.parkinglot.services;

public class ParkingServiceManagerTest {

    public static void main(String[] args) {
        ParkingServiceManagerTest test = new ParkingServiceManagerTest();
        test.testParking();
        test.testUnparking();
    }

    private final ParkingServiceManager parkingServiceManager = new ParkingServiceManager();

    public void testParking() {
        try {
            parkingServiceManager.park("KA01AB1234", "White");
            parkingServiceManager.park("KA01AB4321", "Black");
            parkingServiceManager.park("KA02XY8888", "Red");

            // Attempt to park in a full lot
            parkingServiceManager.park("KA03ZZ9999", "Blue");

        } catch (Exception e) {
            System.out.println("❌ Parking Test Failed: " + e.getMessage());
        }
    }

    public void testUnparking() {
        try {
            // Give some time difference for entry/exit
            Thread.sleep(2000); // simulate 2 seconds parked

            long exitTime = System.currentTimeMillis() + 60 * 60 * 1000;
            parkingServiceManager.unpark(1, exitTime); // Unparking slot 1
        } catch (Exception e) {
            System.out.println("❌ Unparking Test Failed: " + e.getMessage());
        }
    }
}
