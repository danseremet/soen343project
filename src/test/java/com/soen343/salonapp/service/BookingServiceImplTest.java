package com.soen343.salonapp.service;

import com.soen343.salonapp.entity.Booking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class BookingServiceImplTest {

    @Autowired
    private BookingService bookingService;

    @Test
    public void should_get_booking() {
        Booking booking = bookingService.findBooking(1L).get();

        assertEquals("ids are the same", 1L, booking.getId());
        assertEquals("salonIds are the same", 1L, booking.getSalonId());
        assertEquals("customerIds are the same", 1L, booking.getCustomerId());
        assertEquals("startTimes are the same", "2019-12-25T15:00", booking.getStartTime().toString());
        assertEquals("endTimes are the same", "2019-12-26T12:30", booking.getEndTime().toString());
    }

}
