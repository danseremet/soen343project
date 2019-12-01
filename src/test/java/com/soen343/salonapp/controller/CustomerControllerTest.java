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
import static org.springframework.test.util.AssertionErrors.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @Autowired
    CustomerController customerController;

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

    // Not totally sure how to test this since db isnt linked
    @Test
    void should_create_customer()
    {
        Customer customer = new Customer("dan", "hello", "jane@gmail.com", "Dan", "S");
        ResponseEntity<Customer> response = customerController.createCustomer(customer);
        Customer createdCx = response.getBody();

        assertEquals("username is the same", "dan", customer.getUsername());
        assertEquals("password is the same", "hello", customer.getPassword());
        assertEquals("email is the same", "jane@gmail.com", customer.getEmail());
        assertEquals("firstName is the same", "Dan", customer.getFirstName());
        assertEquals("lastName is the same", "S", customer.getLastName());
    }

    @Test
    void should_check_login()
    {
        Customer customer = new Customer("dan", "hello", "jane@gmail.com", "Dan", "S");
        boolean response = customerController.customerLogin(customer);
        assertEquals("username is the same", "dan", customer.getUsername());
        assertEquals("password is the same", "hello", customer.getPassword());
    }

    @Test
    ResponseEntity<Boolean> should_deleteCustomer_byID()
    {
        Long id = 1L;
        ResponseEntity<Boolean> response = customerController.deleteCustomer(id);
        Boolean isCustomer = response.getBody();

        assertNotEquals("client is not in DB anymore", "true", isCustomer);
        return (ResponseEntity<Boolean>) ResponseEntity.ok();
    }



}
