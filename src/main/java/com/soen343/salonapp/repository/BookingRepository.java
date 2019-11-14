package com.soen343.salonapp.repository;

import com.soen343.salonapp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBySalon_Id(Long salonId);

    List<Booking> findByCustomer_Id(Long customerId);
}
