package com.bridgelabz.day26.workshop3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class HotelReservation implements HotelReservationInterface {
    ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    Hotel hotel;

    public void addHotel(String hotelName, int rating, double weekdayRate, double weekendRate) {
        hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setRating(rating);
        hotel.setWeekDayRate(weekdayRate);
        hotel.setWeekendRate(weekendRate);
        hotelList.add(hotel);
    }


    @Override
    public void addHotel() {
        System.out.println();
    }

    public int getHotelListSize() {
        return hotelList.size();
    }

    public void printHotelList() {
        System.out.println(hotelList);
    }

    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }

    public Hotel getCheapestHotel(LocalDate startDate, LocalDate endDate) {

        Optional<Hotel> resultList = hotelList.stream().min(Comparator.comparing(Hotel::getRegularCustomerCost));
        return resultList.get();
    }
}