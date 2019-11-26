package com.soen343.salonapp.service.impl;

import com.soen343.salonapp.entity.Salon;
import com.soen343.salonapp.repository.SalonRepository;
import com.soen343.salonapp.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Override
    public List<Salon> searchSalon(String name){
        List<Salon> allSalons = getSalons();
        List<Salon> foundSalons = new ArrayList();
        
        for(int i = 0; i < allSalons.size(); i++){
            Pattern pattern = Pattern.compile(name);
            Matcher matcher = pattern.matcher(allSalons.get(i).getName());

            if(matcher.find()){
                foundSalons.add(allSalons.get(i));
            }
        }
        return foundSalons;
    }

    // delete by id
    @Override
    public void deleteSalon(Long id) throws EmptyResultDataAccessException {
        salonRepository.deleteById(id);
    }
}
