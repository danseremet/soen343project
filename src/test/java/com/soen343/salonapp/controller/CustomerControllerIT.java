package com.soen343.salonapp.controller;

import com.soen343.salonapp.entity.Customer;
import com.soen343.salonapp.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerIT {

    @Mock
    private CustomerService customerService;

    @Autowired
    private CustomerController customerController;

    @Test
    void should_get_customer_by_existing_id() {
        Long id = 1L;
        ResponseEntity<Customer> response = customerController.getCustomer(id);
        Customer customer = response.getBody();

        assertEquals("username is the same", "danseremet", customer.getUsername());
        assertEquals("password is the same", "123456", customer.getPassword());
        assertEquals("email is the same", "dan@gmail.com", customer.getEmail());
        assertEquals("firstName is the same", "Dan", customer.getFirstName());
        assertEquals("lastName is the same", "S", customer.getLastName());
    }

}
