package com.parkinglot.services.exception;

public class ParkingLotConflictException extends RuntimeException {
    public ParkingLotConflictException(String message) {
        super(message);
    }
}
