package com.soen343.salonapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SalonControllerIT {

    private static String PATH = "/api/v1";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_salons() throws Exception {
        this.mockMvc.perform(get(PATH + "/salons"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Hair Salon")))
                .andExpect(jsonPath("$[0].ownerId", is(1)))
                .andExpect(jsonPath("$[0].availableServicesIds[0]", is(1)))

                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Arts Salon")))
                .andExpect(jsonPath("$[1].ownerId", is(2)))
                .andExpect(jsonPath("$[1].availableServicesIds[0]", is(4)))
        ;
    }

    @Test
    public void should_return_salon() throws Exception {
        this.mockMvc.perform(get(PATH + "/salons/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Hair Salon")))
                .andExpect(jsonPath("$.ownerId", is(1)))
                .andExpect(jsonPath("$.availableServicesIds[0]", is(1)))
        ;
    }

    @Test
    public void should_return_salon_for_salonName() throws Exception {
        this.mockMvc.perform(post(PATH + "/searchResults?name=Hair"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Hair Salon")))
                .andExpect(jsonPath("$[0].ownerId", is(1)))
                .andExpect(jsonPath("$[0].availableServicesIds[0]", is(1)))
        ;
    }


    @Test
    public void should_delete_salon() throws Exception {
        this.mockMvc.perform(delete(PATH + "/salons/3").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$", is(true)))
        ;
    }

}
