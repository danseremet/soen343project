package com.soen343.salonapp.service;

import com.soen343.salonapp.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class CustomerServiceImplTest {


    @Autowired
    private CustomerService customerService;

    @Test
    public void should_get_customer_by_existing_id() {
        Long id = 1L;
        Customer customer = customerService.findCustomer(id).get();

        assertEquals("username is the same", "danseremet", customer.getUsername());
        assertEquals("password is the same", "123456", customer.getPassword());
        assertEquals("email is the same", "dan@gmail.com", customer.getEmail());
        assertEquals("firstName is the same", "Dan", customer.getFirstName());
        assertEquals("lastName is the same", "S", customer.getLastName());
    }

    // Not totally sure how to test this since db isnt linked
    @Test
    public void should_create_customer() {
        Customer c = new Customer("test", "hello", "jane@gmail.com", "Dan", "S");
        Customer customer = customerService.createCustomer(c).get();

        assertEquals("username is the same", "test", customer.getUsername());
        assertEquals("password is the same", "hello", customer.getPassword());
        assertEquals("email is the same", "jane@gmail.com", customer.getEmail());
        assertEquals("firstName is the same", "Dan", customer.getFirstName());
        assertEquals("lastName is the same", "S", customer.getLastName());
    }

    @Test
    public void should_check_login() {
        boolean response = customerService.customerExistsByUserNameAndPassword("dan", "hello");
        assertEquals("returns true", true, response);
    }

    @Test
    public void should_deleteCustomer_byID() {
        customerService.deleteCustomer(3L);
        Customer c = customerService.findCustomer(3L).orElse(new Customer("default", "", "", "", ""));
        assertEquals("client deleted", true, c.getUsername().equals("default"));
    }
}
