package com.soen343.salonapp.controller;

import com.soen343.salonapp.entity.Salon;
import com.soen343.salonapp.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SalonController {
    @Autowired
    SalonService salonService;

    @GetMapping("/salons/{id}")
    public @ResponseBody
    ResponseEntity<Salon> getSalon(@PathVariable("id") Long id) {
        Optional<Salon> salon = salonService.findSalon(id);
        return salon.map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/salons")
    public @ResponseBody
    List<Salon> getSalons() {
        return salonService.getSalons();
    }
    

    @PostMapping("/searchResults")
    public @ResponseBody
    List<Salon> searchSalon(@RequestParam(value = "name") String name) {
        System.out.println(name);
        return salonService.searchSalon(name);
    }


    @DeleteMapping("salons/{id}")
    public @ResponseBody
    HttpStatus deleteSalon(@PathVariable("id") Long id) {
        try {
            salonService.deleteSalon(id);
        } catch (EmptyResultDataAccessException e) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }
}
