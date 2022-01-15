package com.bridgelabz.day26.workshop3;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation implements HotelReservationInterface {
    String hotelName;
    int rating;
    double regularCustomerRate;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    Hotel hotel;

    public void addHotel() {
        System.out.println("How many hotels you want to add");
        int numOfHotels = scanner.nextInt();
        while (numOfHotels > 0) {
            System.out.println("Enter hotel name:");
            hotelName = scanner.next();
            System.out.println("Enter hotel rating:");
            rating = scanner.nextInt();
            System.out.println("Enter regular customer rate:");
            regularCustomerRate = scanner.nextDouble();
            hotel = new Hotel(hotelName, rating, regularCustomerRate);
            hotelList.add(hotel);
        }
    }

    @Override

    public int getHotelListSize() {
        return hotelList.size();
    }

    public void printHotelList() {
        System.out.println(hotelList);
    }
}