package com.bridgelabz.day26.workshop3;

public class Hotel {
    private final String hotelName;
    private final int rating;
    private final double regularCustomerCost;
    private double weekDayRate;
    private double weekendRate;
    private double weekdayRewardCustomerRate;
    private double weekendRewardCustomerRate;

    public Hotel(String hotelName, int rating, double regularCustomerCost) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.regularCustomerCost = regularCustomerCost;
        this.weekDayRate = weekDayRate;
        this.weekendRate = weekendRate;
        this.weekdayRewardCustomerRate = weekdayRewardCustomerRate;
        this.weekendRewardCustomerRate = weekendRewardCustomerRate;
    }

    public double getRegularCustomerCost() {
        return regularCustomerCost;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getRating() {
        return rating;
    }

    public double getWeekDayRate() {
        return weekDayRate;
    }

    public double getWeekendRate() {
        return weekendRate;
    }

    public double getWeekdayRewardCustomerRate() {
        return weekdayRewardCustomerRate;
    }

    public double getWeekendRewardCustomerRate() {
        return weekendRewardCustomerRate;
    }
}
