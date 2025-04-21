package com.parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Car implements Vehicle {

    private String licensePlateNumber;

    private String color;

    public String licensePlateNumber() {
        return licensePlateNumber;
    }

    @Override
    public FuelType fuelType() {
        return FuelType.NON_EV;
    }

    @Override
    public VehicleType vehicleType() {
        return VehicleType.CAR;
    }
}
