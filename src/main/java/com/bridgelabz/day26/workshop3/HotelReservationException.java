package com.bridgelabz.day26.workshop3;

public class HotelReservationException extends RuntimeException {

    public enum ExceptionType {
    }

    ExceptionType type;

    public HotelReservationException(ExceptionType type, String message) {

        super(message);
        this.type = type;

    }
}
