package com.parkinglot.services;

import com.parkinglot.services.core.ParkingService;
import com.parkinglot.services.core.model.Car;
import com.parkinglot.services.core.model.ParkingLot;
import com.parkinglot.services.core.model.Slot;
import com.parkinglot.services.core.strategy.NaturalSortingParkingStrategy;
import com.parkinglot.services.notification.NotificationChannelFactory;
import com.parkinglot.services.notification.SendNotificationService;
import com.parkinglot.services.price.PricingService;
import com.parkinglot.services.price.model.PricingStrategyType;

import java.util.List;

public class ParkingServiceManager {

    private final ParkingService parkingService;
    private final SendNotificationService notificationService;

    public ParkingServiceManager() {
        this.parkingService = new ParkingService();

        ParkingLot parkingLot = new ParkingLot(3); // Assuming constructor sets capacity
        NaturalSortingParkingStrategy strategy = new NaturalSortingParkingStrategy();
        parkingService.createParkingLot(parkingLot, strategy);

        this.notificationService = new SendNotificationService(
                List.of(
                        NotificationChannelFactory.ChannelType.EMAIL,
                        NotificationChannelFactory.ChannelType.SMS
                )
        );
    }

    public void park(String licensePlateNumber, String color) {
        Car vehicle = new Car(licensePlateNumber, color);
        int slotNumber = parkingService.park(vehicle);

        if (slotNumber != -1) {
            String message = "Vehicle parked at slot number: " + slotNumber;
            System.out.println(message);
            notificationService.notify("rkdixit3@gmail.com", message);
        } else {
            String message = "Parking lot is full.";
            System.out.println(message);
            notificationService.notify("rkdixit3@gmail.com", message);
        }
    }

    public void unpark(int slotNumber, long exitTimeInMillis) {
        Slot slot = parkingService.unpark(slotNumber);

        if (slot == null || slot.getEntryTime() == 0) {
            String message = "Invalid slot or vehicle not found.";
            System.out.println(message);
            notificationService.notify("rkdixit3@gmail.com", message);
            return;
        }

        long entryTimeInMillis = slot.getEntryTime();
        double price = PricingService.calculatePrice(
                PricingStrategyType.SURGE,
                entryTimeInMillis,
                exitTimeInMillis
        );

        String message = String.format("Vehicle unparked from slot %d. Total fee: ₹%.2f", slotNumber, price);
        System.out.println(message);
        notificationService.notify("rkdixit3@gmail.com", message);
    }
}
