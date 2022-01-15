package com.bridgelabz.day26.workshop3;

import java.time.LocalDate;
import java.util.ArrayList;

public interface HotelReservationInterface {
    public void addHotel(String hotelName, int rating, double weekdayRegularCustomerCost, double weekendRegularCustomerCost, int i, int i1);

    void addHotel(String lakewood, int i, int i1, int i2);

    public int getHotelListSize();

    public void printHotelList();

    public ArrayList<Hotel> getHotelList();

    public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate);

    public Hotel getCheapestBestRatedHotel(LocalDate startDate, LocalDate endDate);

    public Hotel getBestRatedHotel(LocalDate startDate, LocalDate endDate);

    public ArrayList<Integer> getDurationOfStayDetails(LocalDate startDate, LocalDate endDate);
}