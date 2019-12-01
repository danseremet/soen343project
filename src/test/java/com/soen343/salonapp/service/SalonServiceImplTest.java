package com.soen343.salonapp.service;

import com.soen343.salonapp.entity.Booking;
import com.soen343.salonapp.entity.Salon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SalonServiceImplTest {

    @Autowired
    private SalonService salonService;

    @Test
    public void should_get_salon() {
        Salon salon = salonService.findSalon(1L).get();

        assertEquals("ids are the same", 1L, salon.getId());
        assertEquals("ownerIds are the same", 1L, salon.getOwnerId());
        assertEquals("names are the same", "Hair Salon", salon.getName());
    }

}