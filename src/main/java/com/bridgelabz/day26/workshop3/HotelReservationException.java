package com.bridgelabz.day26.workshop3;

public class HotelReservationException extends RuntimeException {

    enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY;
    }

    ExceptionType type;

    public HotelReservationException(ExceptionType type, String message) {

        super(message);
        this.type = type;

    }
}
