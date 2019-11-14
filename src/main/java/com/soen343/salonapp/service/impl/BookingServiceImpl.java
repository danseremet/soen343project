package com.soen343.salonapp.service.impl;

import com.soen343.salonapp.entity.Booking;
import com.soen343.salonapp.repository.BookingRepository;
import com.soen343.salonapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    // aggregate
    @Override
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    // one by id
    @Override
    public Optional<Booking> findBooking(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public List<Booking> findBookingsForCustomer(Long customerId) {
        return bookingRepository.findByCustomer_Id(customerId);
    }

    @Override
    public List<Booking> findBookingsForSalon(Long salonId) {
        return bookingRepository.findBySalon_Id(salonId);
    }

    @Override
    public Optional<Booking> createBooking(Booking booking) {
        // TODO handle time conflicts

        return Optional.of(bookingRepository.save(booking));
    }

    @Override
    public Optional<Booking> modifyBooking(Booking booking) {
        // TODO handle time conflicts
        Optional<Booking> savedBooking = findBooking(booking.getId());
        if (savedBooking.isPresent()) {
            Booking updatedBooking = savedBooking.get();
            System.out.println(updatedBooking);
            if (booking.getStartTime() != null) {
                updatedBooking.setStartTime(booking.getStartTime());
            }
            if (booking.getEndTime() != null) {
                updatedBooking.setEndTime(booking.getEndTime());
            }
            return Optional.of(bookingRepository.save(updatedBooking));
        }
        return Optional.empty();
    }

    @Override
    public void deleteBooking(Long bookingId) {
        // TODO handle paid/unpaid cases
        bookingRepository.deleteById(bookingId);
    }
}
