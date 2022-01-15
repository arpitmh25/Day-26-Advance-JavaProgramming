package com.bridgelabz.day26.workshop3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public void addHotel(String lakewood, int i, int i1, int i2) {
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

    @Override
    public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate, double cheapestPrice, double price) {
        return null;
    }

    @Override
    public Hotel getCheapestBestRatedHotel(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public Hotel getBestRatedHotel(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    public ArrayList<Integer> getDurationOfStayDetails(LocalDate startDate, LocalDate endDate) {

        ArrayList<Integer> durationDetails = new ArrayList<Integer>();
        int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
        int weekends = 0;
        while (startDate.compareTo(endDate) != 0) {
            switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
                case SATURDAY:
                    ++weekends;
                    break;
                case SUNDAY:
                    ++weekends;
                    break;
                default:
                    break;
            }
            startDate = startDate.plusDays(1);
        }

        int weekdays = numberOfDays - weekends;
        durationDetails.add(weekdays);
        durationDetails.add(weekends);
        return durationDetails;

    }

    public ArrayList<Hotel> getCheapestHotel(String customerType, LocalDate startDate, LocalDate endDate, double cheapestPrice) {

        ArrayList<Integer> durationDetails = getDurationOfStayDetails(startDate, endDate);
        int weekdaysNumber = durationDetails.get(0);
        int weekendsNumber = durationDetails.get(1);
        ArrayList<Hotel> cheapestHotel = new ArrayList<Hotel>();

        if (customerType.equalsIgnoreCase("Regular")) {

            cheapestPrice = hotelList.stream()
                    .mapToDouble(hotel -> ((hotel.getWeekendRate() * weekendsNumber)
                            + hotel.getWeekDayRate() * weekdaysNumber))
                    .min().orElse(Double.MAX_VALUE);

            double finalCheapestPrice1 = cheapestPrice;
            cheapestHotel = hotelList.stream()
                    .filter(hotel -> (hotel.getWeekendRate() * weekendsNumber
                            + hotel.getWeekDayRate() * weekdaysNumber) == finalCheapestPrice1)
                    .collect(Collectors.toCollection(ArrayList::new));
        } else if (customerType.equalsIgnoreCase("Reward")) {
            cheapestPrice = hotelList.stream()
                    .mapToDouble(hotel -> ((hotel.getWeekendRewardCustomerRate() * weekendsNumber)
                            + hotel.getWeekdayRewardCustomerRate() * weekdaysNumber))
                    .min().orElse(Double.MAX_VALUE);

            double finalCheapestPrice = cheapestPrice;
            cheapestHotel = hotelList.stream()
                    .filter(hotel -> (hotel.getWeekendRewardCustomerRate() * weekendsNumber
                            + hotel.getWeekdayRewardCustomerRate() * weekdaysNumber) == finalCheapestPrice)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (cheapestPrice != Double.MAX_VALUE) {
            Iterator<Hotel> iterator = cheapestHotel.iterator();
            System.out.println("Cheap Hotels : \n");
            while (iterator.hasNext()) {
                System.out.println(iterator.next().getHotelName() + ", Total Rates: " + cheapestPrice);
            }
            return cheapestHotel;
        }
        return null;


    }

    public Hotel getCheapestBestRatedHotel(String customerType, LocalDate startDate, LocalDate endDate, Object ExceptionType, double cheapestPrice, HotelReservationException.ExceptionType ENTERED_NULL, HotelReservationException.ExceptionType ENTERED_EMPTY) {

        try {

            if (customerType.length() == 0)
                throw new HotelReservationException(ENTERED_EMPTY, "EMPTY Value Entered");

            ArrayList<Hotel> cheapestHotels = getCheapestHotel(customerType, startDate, endDate, cheapestPrice);
            Optional<Hotel> sortedHotelList = cheapestHotels.stream()
                    .max(Comparator.comparing(Hotel::getRating));

            System.out.println("Cheapest Best Rated Hotel : \n" + sortedHotelList.get().getHotelName() + ", Total Rates: "
                    + cheapestPrice);
            return sortedHotelList.get();
        } catch (NullPointerException e) {
            throw new HotelReservationException(ENTERED_NULL, "NULL Value Entered");
        }
    }

    public Hotel getBestRatedHotel(String customerType, LocalDate startDate, LocalDate endDate, HotelReservationException.ExceptionType ENTERED_EMPTY) {

        try {

            if (customerType.length() == 0)
                throw new HotelReservationException(ENTERED_EMPTY, "EMPTY Value Entered");

            ArrayList<Integer> durationDetails = getDurationOfStayDetails(startDate, endDate);
            int weekdaysNumber = durationDetails.get(0);
            int weekendsNumber = durationDetails.get(1);
            double totalPrice = 0;

            Optional<Hotel> sortedHotelList = hotelList.stream()
                    .max(Comparator.comparing(Hotel::getRating));

            if (customerType.equalsIgnoreCase("Regular")) {

                totalPrice = weekdaysNumber * sortedHotelList.get().getWeekdayRewardCustomerRate()
                        + weekendsNumber * sortedHotelList.get().getWeekendRewardCustomerRate();
            } else if (customerType.equalsIgnoreCase("Reward")) {

                totalPrice = weekdaysNumber * sortedHotelList.get().getWeekdayRewardCustomerRate()
                        + weekendsNumber * sortedHotelList.get().getWeekendRewardCustomerRate();
            }


            System.out.println("Best Rated Hotel : \n" + sortedHotelList.get().getHotelName() + ", Rating : "
                    + sortedHotelList.get().getRating() + ", Total Rates: " + totalPrice);
            return sortedHotelList.get();
        } catch (NullPointerException e) {
            throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_NULL, "NULL Value Entered");
        }
    }

    private class ENTERED_EMPTY {
    }
}
