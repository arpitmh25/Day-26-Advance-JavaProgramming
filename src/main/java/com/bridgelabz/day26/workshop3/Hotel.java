package com.bridgelabz.day26.workshop3;

public class Hotel {
    private final String hotelName;
    private final int regularRate;

    public Hotel(String hotelName, int regularRate) {
        this.hotelName = hotelName;
        this.regularRate = regularRate;
    }

    public String getHotelName() {
        return hotelName;
    }


    public int getRegularRate() {
        return regularRate;
    }
}
