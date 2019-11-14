package com.soen343.salonapp.service.impl;

import com.soen343.salonapp.entity.Salon;
import com.soen343.salonapp.repository.SalonRepository;
import com.soen343.salonapp.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SalonServiceImpl implements SalonService {

    @Autowired
    SalonRepository salonRepository;

    // aggregate
    @Override
    public List<Salon> getSalons() {
        return salonRepository.findAll();
    }

    // one by id
    @Override
    public Optional<Salon> findSalon(Long id) {
        return salonRepository.findById(id);
    }

    // delete by id
    @Override
    public void deleteSalon(Long id) throws EmptyResultDataAccessException {
        salonRepository.deleteById(id);
    }
}
