package com.bridgelab.day26.workshop3;

import com.bridgelabz.day26.workshop3.Hotel;
import com.bridgelabz.day26.workshop3.HotelReservation;
import com.bridgelabz.day26.workshop3.HotelReservationException;
import com.bridgelabz.day26.workshop3.HotelReservationInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class HotelReservationTest {

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelName(Assertions Assert) {
        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 110, 90);
        String hotelName = String.valueOf(hotelReservation.getHotelList().get(0).getHotelName());
        Assert.assertEquals("Bridgewood", hotelName);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelRating(Assertions Assert) {
        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 150, 50);
        int hotelRating = hotelReservation.getHotelList().get(0).getRating();
        Assert.assertEquals(4, hotelRating);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnWeekDayRate(Assertions Assert) {
        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 150, 50);
        int weekDayRate = (int) hotelReservation.getHotelList().get(0).getWeekDayRate();
        Assert.assertEquals(150, weekDayRate);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnWeekendRate(Assertions Assert) {
        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 220, 150);
        int weekendRate = (int) hotelReservation.getHotelList().get(0).getWeekendRate();
        Assert.assertEquals(150, weekendRate);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnWeekDayRewardRate(Assertions Assert) {
        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        int weekdayRewardRate = (int) hotelReservation.getHotelList().get(0).getWeekdayRewardCustomerRate();
        Assert.assertEquals(110, weekdayRewardRate);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnWeekendRewardRate(Assertions Assert) {
        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 220, 150, 110, 50);
        int weekendRewardRate = (int) hotelReservation.getHotelList().get(0).getWeekendRewardCustomerRate();
        Assert.assertEquals(50, weekendRewardRate);
    }

    @Test
    public void givenHotelDetails_WhenSizeMatches_ShouldReturnTrue(Assertions Assert) {
        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50);
        hotelReservation.addHotel("Ridgewood", 5, 220, 150);
        int hotelListSize = hotelReservation.getHotelListSize();
        Assert.assertEquals(3, hotelListSize);
    }

    @Test
    public void givenHotelDetails_shouldReturnCheapestHotel(Assertions Assert, double cheapestPrice) {

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90);
        hotelReservation.addHotel("Bridgewood", 4, 160, 50);
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        String hotelName = String.valueOf(hotelReservation.getCheapestHotel(startDate, endDate, String.valueOf(cheapestPrice), cheapestPrice));
        Assert.assertEquals("Lakewood", hotelName);
    }

    @Test
    public void givenHotelDetails_WhenRegularCustomerAndHotelPricesAreSame_ShouldReturnCheapestHighestRatedHotel(Assertions Assert) {

        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);

        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        String startDateToValidate = startDate.toString();
        String endDateToValidate = endDate.toString();
        boolean isValidStartDate = hotelReservation.validateDate(startDateToValidate);
        boolean isValidEndDate = hotelReservation.validateDate(endDateToValidate);

        if (isValidStartDate && isValidEndDate) {
            Hotel hotel = hotelReservation.getCheapestBestRatedHotel("regular", startDate, endDate);
            Assert.assertEquals("Bridgewood", ((Hotel) hotel).getHotelName());
        } else {
            System.out.println("Not Valid Start Or End date");
        }
    }

    @Test
    public void givenHotelDetails_WhenRewardCustomer_ShouldReturnCheapestHotel(Assertions Assert) {

        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);

        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        String startDateToValidate = startDate.toString();
        String endDateToValidate = endDate.toString();
        boolean isValidStartDate = hotelReservation.validateDate(startDateToValidate);
        boolean isValidEndDate = hotelReservation.validateDate(endDateToValidate);

        if (isValidStartDate && isValidEndDate) {
            ArrayList<Hotel> hotel = hotelReservation.getCheapestHotel("reward", startDate, endDate);
            String hotelName = hotel.get(0).getHotelName() + " " + hotel.get(1).getHotelName();
            Assert.assertEquals("Lakewood Bridgewood", hotelName);
        } else {
            System.out.println("Not Valid Start Or End date");
        }
    }

    @Test
    public void givenHotelDetails_WhenRewardCustomerAndHotelPricesAreSame_ShouldReturnCheapestHighestRatedHotel(Assertions Assert) {

        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);

        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        String startDateToValidate = startDate.toString();
        String endDateToValidate = endDate.toString();
        boolean isValidStartDate = hotelReservation.validateDate(startDateToValidate);
        boolean isValidEndDate = hotelReservation.validateDate(endDateToValidate);

        if (isValidStartDate && isValidEndDate) {
            Hotel hotel = hotelReservation.getCheapestBestRatedHotel("reward", startDate, endDate);
            Assert.assertEquals("Bridgewood", hotel.getHotelName());
        } else {
            System.out.println("Not Valid Start Or End date");
        }
    }

    @Test
    public void givenHotelDetails_WhenRewardCustomer_ShouldReturnHighestRatedHotel(Assertions Assert) {

        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);

        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        String startDateToValidate = startDate.toString();
        String endDateToValidate = endDate.toString();
        boolean isValidStartDate = hotelReservation.validateDate(startDateToValidate);
        boolean isValidEndDate = hotelReservation.validateDate(endDateToValidate);

        if (isValidStartDate && isValidEndDate) {
            Hotel hotel = hotelReservation.getBestRatedHotel("reward", startDate, endDate);
            Assert.assertEquals("Ridgewood", hotel.getHotelName());
        } else {
            System.out.println("Not Valid Start Or End date");
        }
    }

    @Test
    public void givenHotelDetails_shouldReturnBestRatedHotel(Assertions Assert) {

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90);
        hotelReservation.addHotel("Bridgewood", 4, 160, 50);
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        String hotelName = String.valueOf(hotelReservation.getBestRatedHotel(startDate, endDate));
        Assert.assertEquals("Bridgewood", hotelName);
    }

    @Test
    public void givenHotelDetails_WhenNull_ShouldThrowHotelReservationException(Assertions Assert, double cheapestPrice) {


        try {
            HotelReservation hotelReservation = new HotelReservation();
            hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
            hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
            hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
            LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
            LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
            hotelReservation.getCheapestHotel(startDate, endDate, null, cheapestPrice);
        } catch (HotelReservationException e) {
            Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_NULL, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenHotelDetails_WhenEmpty_ShouldThrowHotelReservationException(Assertions Assert, double cheapestPrice) {


        try {
            HotelReservation hotelReservation = new HotelReservation();
            hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
            hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
            hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
            LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
            LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
            hotelReservation.getCheapestHotel(startDate, endDate, "", cheapestPrice);
        } catch (HotelReservationException e) {
            Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_EMPTY, e.type);
            e.printStackTrace();
        }

    }

}
