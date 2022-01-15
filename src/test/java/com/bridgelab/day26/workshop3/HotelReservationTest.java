package com.bridgelab.day26.workshop3;

import com.bridgelabz.day26.workshop3.HotelReservation;
import com.bridgelabz.day26.workshop3.HotelReservationInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {
    @Test
    public void givenHotelDetails_WhenSizeMatch_ShouldReturnTrue(Assertions Assert) {
        HotelReservationInterface hotelReservation = (HotelReservationInterface) new HotelReservation();
        hotelReservation.addHotel();
        int hotelListSize = hotelReservation.getHotelListSize();
        Assert.assertEquals(3, hotelListSize);
    }
}
