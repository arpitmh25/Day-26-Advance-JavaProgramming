package com.bridgelabz.day26.workshop3;

public class Hotel {
    private String hotelName;
    private int rating;
    private double weekDayRate;
    private double weekendRate;
    private double weekdayRewardCustomerRate;
    private double weekendRewardCustomerRate;
    private double regularCustomerCost;

    public Hotel() {
        this.weekDayRate = weekDayRate;
        this.weekendRate = weekendRate;
        this.weekdayRewardCustomerRate = weekdayRewardCustomerRate;
        this.weekendRewardCustomerRate = weekendRewardCustomerRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setRegularCustomerCost(int regularCustomerCost) {
        this.regularCustomerCost = regularCustomerCost;
    }

    public int getRegularCustomerCost() {
        return (int) regularCustomerCost;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getWeekDayRate() {
        return weekDayRate;
    }

    public void setWeekDayRate(double weekDayRate) {
        this.weekDayRate = weekDayRate;
    }

    public double getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(double weekendRate) {
        this.weekendRate = weekendRate;
    }

    public double getWeekdayRewardCustomerRate() {
        return weekdayRewardCustomerRate;
    }

    public void setWeekdayRewardCustomerRate(double weekdayRewardCustomerRate) {
        this.weekdayRewardCustomerRate = weekdayRewardCustomerRate;
    }

    public double getWeekendRewardCustomerRate() {
        return weekendRewardCustomerRate;
    }

    public void setWeekendRewardCustomerRate(double weekendRewardCustomerRate) {
        this.weekendRewardCustomerRate = weekendRewardCustomerRate;
    }

    @Override
    public String toString() {
        return "Hotel [hotelName=" + hotelName + ", ratings=" + rating + ", weekDayRate=" + weekDayRate
                + ", weekendRate=" + weekendRate + ", weekdayRewardCustomerRate=" + weekdayRewardCustomerRate
                + ", weekendRewardCustomerRate=" + weekendRewardCustomerRate + "]";
    }
}
