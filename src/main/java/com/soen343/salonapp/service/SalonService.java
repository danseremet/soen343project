package com.soen343.salonapp.service;

import com.soen343.salonapp.entity.Salon;

import java.util.List;
import java.util.Optional;

public interface SalonService {

    List<Salon> getSalons();

    // one by id
    Optional<Salon> findSalon(Long id);

    List<Salon> searchSalon(String name);

    void deleteSalon(Long id);
}
