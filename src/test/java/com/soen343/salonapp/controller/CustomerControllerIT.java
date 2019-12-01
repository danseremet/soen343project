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
public class CustomerControllerIT {

    private static String PATH = "/api/v1";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_customers() throws Exception {
        this.mockMvc.perform(get(PATH + "/customers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].username", is("danseremet")))
                .andExpect(jsonPath("$[0].password", is("123456")))
                .andExpect(jsonPath("$[0].email", is("dan@gmail.com")))
                .andExpect(jsonPath("$[0].firstName", is("Dan")))
                .andExpect(jsonPath("$[0].lastName", is("S")))

                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].username", is("johndoe")))
        ;
    }

    @Test
    public void should_return_customer() throws Exception {
        this.mockMvc.perform(get(PATH + "/customers/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.username", is("danseremet")))
        ;
    }



}
