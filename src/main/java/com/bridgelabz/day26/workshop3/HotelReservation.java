package com.bridgelabz.day26.workshop3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;


public class HotelReservation implements HotelReservationInterface {

    public static Scanner scannerObject = new Scanner(System.in);
    public ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    public Hotel hotel;
    public static double cheapestPrice;

    public void addHotel(String hotelName, int rating, double weekdayRegularCustomerCost,
                         double weekendRegularCustomerCost, double weekdayRewardCustomerCost, double weekendRewardCustomerCost) {

        hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setRating(rating);
        hotel.setWeekDayRate(weekdayRegularCustomerCost);
        hotel.setWeekendRate(weekendRegularCustomerCost);
        hotel.setWeekdayRewardCustomerRate(weekdayRewardCustomerCost);
        hotel.setWeekendRewardCustomerRate(weekendRewardCustomerCost);
        hotelList.add(hotel);
        System.out.println("Successfully ADDED !!");
    }

    @Override
    public void addHotel(String hotelName, int rating, double weekdayRegularCustomerCost, double weekendRegularCustomerCost, int i, int i1) {
        return;
    }

    @Override
    public void addHotel(String hotelName, int rating, double weekdayRegularCustomerCost, double weekendRegularCustomerCost, int i, int i1) {

    }

    @Override
    public void addHotel(String lakewood, int i, int i1, int i2) {
        return;
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
    public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate, String s, double cheapestPrice) {
        return null;
    }

    public String getDates() {
        System.out.println("Enter the Date in YYYY-MM-DD: ");
        String date = scannerObject.next();
        boolean isValid = validateDate(date);
        if (isValid)
            return date;

    public ArrayList<Hotel> getCheapestHotel(String customerType, LocalDate startDate, LocalDate endDate) {
        return null;
    }

    public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate, double cheapestPrice, double price) {
        return null;
    }

    public boolean validateDate(String date) {

        try {
            if (date.length() == 0)
                throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_NOTHING, "Date Is EMPTY");

            String dateRegEx = "^([0-9]{4})[-](([0][1-9])|([1][0-2]))[-]([0-2][0-9]|(3)[0-1])$";
            return date.matches(dateRegEx);
        } catch (NullPointerException e) {
            throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_NULL, "Date is NULL");
        }


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

    public ArrayList<Hotel> getCheapestHotel(String customerType, LocalDate startDate, LocalDate endDate) {

        ArrayList<Integer> durationDetails = getDurationOfStayDetails(startDate, endDate);
        int weekdaysNumber = durationDetails.get(0);
        int weekendsNumber = durationDetails.get(1);
        ArrayList<Hotel> cheapestHotel = new ArrayList<Hotel>();

        if (customerType.equalsIgnoreCase("Regular")) {

            cheapestPrice = hotelList.stream()
                    .mapToDouble(hotel -> ((hotel.getWeekendRate() * weekendsNumber)
                            + hotel.getWeekDayRate() * weekdaysNumber))
                    .min().orElse(Double.MAX_VALUE);

            cheapestHotel = hotelList.stream()
                    .filter(hotel -> (hotel.getWeekendRate() * weekendsNumber
                            + hotel.getWeekDayRate() * weekdaysNumber) == cheapestPrice)

            double finalCheapestPrice = cheapestPrice;
            cheapestHotel = hotelList.stream()
                    .filter(hotel -> (hotel.getWeekendRate() * weekendsNumber
                            + hotel.getWeekDayRate() * weekdaysNumber) == finalCheapestPrice)
                    .collect(Collectors.toCollection(ArrayList::new));
        } else if (customerType.equalsIgnoreCase("Reward")) {

            cheapestPrice = hotelList.stream()
                    .mapToDouble(hotel -> ((hotel.getWeekendRewardCustomerRate() * weekendsNumber)
                            + hotel.getWeekdayRewardCustomerRate() * weekdaysNumber))
                    .min().orElse(Double.MAX_VALUE);


            cheapestHotel = hotelList.stream()
                    .filter(hotel -> (hotel.getWeekendRewardCustomerRate() * weekendsNumber
                            + hotel.getWeekdayRewardCustomerRate() * weekdaysNumber) == cheapestPrice)

            double finalCheapestPrice1 = cheapestPrice;
            cheapestHotel = hotelList.stream()
                    .filter(hotel -> (hotel.getWeekendRewardCustomerRate() * weekendsNumber
                            + hotel.getWeekdayRewardCustomerRate() * weekdaysNumber) == finalCheapestPrice1)

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


    public Hotel getCheapestBestRatedHotel(String customerType, LocalDate startDate, LocalDate endDate) {

    public Hotel getCheapestBestRatedHotel(String customerType, LocalDate startDate, LocalDate endDate, HotelReservationException.ExceptionType ENTERED_EMPTY, String cheapestPrice, HotelReservationException.ExceptionType ENTERED_NULL) {


        try {

            if (customerType.length() == 0)
                throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_NOTHING, "EMPTY Value Entered");

            ArrayList<Hotel> cheapestHotels = getCheapestHotel(customerType, startDate, endDate);
            Optional<Hotel> sortedHotelList = cheapestHotels.stream()
                    .max(Comparator.comparing(Hotel::getRating));

            System.out.println("Cheapest Best Rated Hotel : \n" + sortedHotelList.get().getHotelName() + ", Total Rates: "
                    + cheapestPrice);
            return sortedHotelList.get();
        } catch (NullPointerException e) {
            throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_NULL, "NULL Value Entered");
        }
    }


    @Override
    public Hotel getBestRatedHotel(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    public Hotel getBestRatedHotel(String customerType, LocalDate startDate, LocalDate endDate) {

    public Hotel getBestRatedHotel(String customerType, LocalDate startDate, LocalDate endDate, HotelReservationException.ExceptionType ENTERED_NULL, HotelReservationException.ExceptionType ENTERED_EMPTY) {


        try {

            if (customerType.length() == 0)
                throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_NOTHING, "EMPTY Value Entered");

            ArrayList<Integer> durationDetails = getDurationOfStayDetails(startDate, endDate);
            int weekdaysNumber = durationDetails.get(0);
            int weekendsNumber = durationDetails.get(1);
            double totalPrice = 0;

            Optional<Hotel> sortedHotelList = hotelList.stream()
                    .max(Comparator.comparing(Hotel::getRating));

            if (customerType.equalsIgnoreCase("Regular")) {

                totalPrice = weekdaysNumber * sortedHotelList.get().getWeekDayRate()
                        + weekendsNumber * sortedHotelList.get().getWeekendRate();
            } else if (customerType.equalsIgnoreCase("Reward")) {

                totalPrice = weekdaysNumber * sortedHotelList.get().getWeekdayRewardCustomerRate()
                        + weekendsNumber * sortedHotelList.get().getWeekendRewardCustomerRate();
            }


            System.out.println("Best Rated Hotel : \n" + sortedHotelList.get().getHotelName() + ", Rating : "
                    + sortedHotelList.get().getRating() + ", Total Rates: " + totalPrice);
            return sortedHotelList.get();
        } catch (NullPointerException e) {
            throw new HotelReservationException(ENTERED_NULL, "NULL Value Entered");
        }

    }

