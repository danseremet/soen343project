package com.soen343.salonapp.service;

import com.soen343.salonapp.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<Booking> getBookings();

    // one by id
    Optional<Booking> findBooking(Long id);

    List<Booking> findBookingsForCustomer(Long customerId);

    List<Booking> findBookingsForSalon(Long salonId);

    Optional<Booking> createBooking(Booking booking);

    Optional<Booking> modifyBooking(Booking booking);

    void deleteBooking(Long bookingId);
}
