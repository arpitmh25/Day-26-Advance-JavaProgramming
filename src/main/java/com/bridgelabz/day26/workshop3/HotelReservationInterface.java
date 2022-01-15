package com.bridgelabz.day26.workshop3;

import java.time.LocalDate;
import java.util.ArrayList;

public interface HotelReservationInterface {
    public void addHotel(String hotelName, int rating, double weekdayRegularCustomerCost, double weekendRegularCustomerCost, int i, int i1);

    void addHotel(String lakewood, int i, int i1, int i2);

    public int getHotelListSize();

    public void printHotelList();

    public String getDates();

    public boolean validateDate(String date);

    public ArrayList<Hotel> getHotelList();

    public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate, String s, double cheapestPrice);

    public Hotel getCheapestBestRatedHotel(String reward, LocalDate startDate, LocalDate endDate);

    public Hotel getBestRatedHotel(LocalDate startDate, LocalDate endDate);

    public ArrayList<Integer> getDurationOfStayDetails(LocalDate startDate, LocalDate endDate);

    ArrayList<Hotel> getCheapestHotel(String reward, LocalDate startDate, LocalDate endDate);

    Hotel getBestRatedHotel(String reward, LocalDate startDate, LocalDate endDate);
}
