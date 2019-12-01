package com.soen343.salonapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class BookingControllerIT {

    private static String PATH = "/api/v1";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void should_return_bookings() throws Exception {
        this.mockMvc.perform(get(PATH + "/bookings"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].startTime", is("2019-12-25T15:00:00")))
                .andExpect(jsonPath("$[0].endTime", is("2019-12-26T12:30:00")))
                .andExpect(jsonPath("$[0].paid", is(false)))
                .andExpect(jsonPath("$[0].salonId", is(1)))
                .andExpect(jsonPath("$[0].customerId", is(1)))

                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].startTime", is("2019-11-25T15:00:00")))
                .andExpect(jsonPath("$[1].endTime", is("2019-11-26T12:30:00")))
                .andExpect(jsonPath("$[1].paid", is(false)))
                .andExpect(jsonPath("$[1].salonId", is(1)))
                .andExpect(jsonPath("$[1].customerId", is(2)))

        ;
    }

    @Test
    public void should_return_bookings_for_salon() throws Exception {
        this.mockMvc.perform(get(PATH + "/bookings/salon/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].startTime", is("2019-12-25T15:00:00")))
                .andExpect(jsonPath("$[0].endTime", is("2019-12-26T12:30:00")))
                .andExpect(jsonPath("$[0].paid", is(false)))
                .andExpect(jsonPath("$[0].salonId", is(1)))
                .andExpect(jsonPath("$[0].customerId", is(1)))

                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].startTime", is("2019-11-25T15:00:00")))
                .andExpect(jsonPath("$[1].endTime", is("2019-11-26T12:30:00")))
                .andExpect(jsonPath("$[1].paid", is(false)))
                .andExpect(jsonPath("$[1].salonId", is(1)))
                .andExpect(jsonPath("$[1].customerId", is(2)))

        ;
    }

    @Test
    public void should_create_booking() throws Exception {
        this.mockMvc.perform(post(PATH + "/bookings").contentType(MediaType.APPLICATION_JSON).content(
                "{\"customerId\": 1," +
                "  \"endTime\": \"2020-12-30T22:45:20.704\"," +
                "  \"salonId\": 1," +
                "  \"startTime\": \"2020-12-30T22:45:20.704\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.customerId", is(1)))
                .andExpect(jsonPath("$.startTime", is("2020-12-30T22:45:20.704")))
                .andExpect(jsonPath("$.endTime", is("2020-12-30T22:45:20.704")))
                .andExpect(jsonPath("$.salonId", is(1)))
        ;

    }

//    @Test TODO
    public void should_modify_booking() throws Exception {
        this.mockMvc.perform(put(PATH + "/bookings").contentType(MediaType.APPLICATION_JSON).content(
                "{\"customerId\": 1," +
                        "  \"id\": \"1," +
                        "  \"salonId\": \"0," +
                        "  \"endTime\": \"2025-12-30T22:45:20.704\"," +
                        "  \"startTime\": \"2025-12-30T22:45:20.704\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.customerId", is(1)))
                .andExpect(jsonPath("$.startTime", is("2020-12-30T22:45:20.704")))
                .andExpect(jsonPath("$.endTime", is("2020-12-30T22:45:20.704")))
                .andExpect(jsonPath("$.salonId", is(1)))
        ;

    }

}
