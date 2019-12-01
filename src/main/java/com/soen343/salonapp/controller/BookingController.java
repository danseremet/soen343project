package com.soen343.salonapp.controller;

import com.soen343.salonapp.dto.BookingDTO;
import com.soen343.salonapp.entity.Booking;
import com.soen343.salonapp.entity.Customer;
import com.soen343.salonapp.entity.Salon;
import com.soen343.salonapp.service.BookingService;
import com.soen343.salonapp.service.CustomerService;
import com.soen343.salonapp.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class BookingController {

    @PostConstruct
    void populate() {
        // TODO move this to data.sql
        BookingDTO bookingDTO1 = new BookingDTO(LocalDateTime.of(2019, 12, 25, 15, 0),
                LocalDateTime.of(2019, 12, 26, 12, 30), 1L, 1L);
        BookingDTO bookingDTO2 = new BookingDTO(LocalDateTime.of(2019, 12, 25, 15, 0),
                LocalDateTime.of(2019, 12, 26, 12, 30), 1L, 2L);
        createBooking(bookingDTO1);
        createBooking(bookingDTO2);
    }

    @Autowired
    private SalonService salonService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/bookings")
    public @ResponseBody
    List<Booking> getSalons() {
        return bookingService.getBookings();
    }

    @GetMapping("/bookings/salon/{id}")
    public @ResponseBody
    List<Booking> findBookingsForSalon(@PathVariable("id") Long salonId) {
        return bookingService.findBookingsForSalon(salonId);
    }

    @GetMapping("/bookings/customer/{id}")
    public @ResponseBody
    List<Booking> findBookingsForCustomer(@PathVariable("id") Long customerId) {
        return bookingService.findBookingsForCustomer(customerId);
    }

    @PostMapping("/bookings")
    public @ResponseBody
    ResponseEntity<Booking> createBooking(@RequestBody BookingDTO bookingDTO) {
        Optional<Salon> salon = salonService.findSalon(bookingDTO.getSalonId());
        Optional<Customer> customer = customerService.findCustomer(bookingDTO.getCustomerId());

        if (salon.isPresent() && customer.isPresent()) {
            Booking booking = new Booking(
                    bookingDTO.getStartTime(), bookingDTO.getEndTime(),
                    salon.get(), customer.get());

            Optional<Booking> savedBooking = bookingService.createBooking(booking);
            return savedBooking.map(sb -> new ResponseEntity<>(sb, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.CONFLICT));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/bookings")
    public @ResponseBody
    ResponseEntity<Booking> modifyBooking(@RequestBody Booking booking) {
        return bookingService.modifyBooking(booking)
                .map(updatedBooking -> new ResponseEntity<>(updatedBooking, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("bookings/{id}")
    public @ResponseBody
    ResponseEntity<Boolean> deleteBooking(@PathVariable("id") Long id) {
        try {
            bookingService.deleteBooking(id);
        } catch (EmptyResultDataAccessException e) {
            return (ResponseEntity<Boolean>) ResponseEntity.notFound();
        }
        return (ResponseEntity<Boolean>) ResponseEntity.ok();
    }
}
