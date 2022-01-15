package com.bridgelab.day26.workshop3;

import com.bridgelabz.day26.workshop3.HotelReservation;
import com.bridgelabz.day26.workshop3.HotelReservationInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelName(Assertions Assert) {
        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 110, 90);
        String hotelName = hotelReservation.getHotelList().get(0).getHotelName();
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
    public void givenHotelDetails_WhenSizeMatches_ShouldReturnTrue(Assertions Assert) {
        HotelReservationInterface hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50);
        hotelReservation.addHotel("Ridgewood", 5, 220, 150);
        int hotelListSize = hotelReservation.getHotelListSize();
        Assert.assertEquals(3, hotelListSize);
    }
}
