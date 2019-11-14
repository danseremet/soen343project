package com.soen343.salonapp.controller;

import com.soen343.salonapp.entity.Customer;
import com.soen343.salonapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers/{id}")
    public @ResponseBody
    ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findCustomer(id);
        return customer.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/customers")
    public @ResponseBody
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/customers")
    public @ResponseBody
    ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        Optional<Customer> savedCustomer = customerService.createCustomer(customer);
        return savedCustomer.map(sc -> new ResponseEntity<>(sc, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // no security
    @PostMapping("/customer/login")
    public @ResponseBody
    boolean customerLogin(@RequestBody Customer customer) {
        return customerService.customerExistsByUserNameAndPassword(customer.getUsername(), customer.getPassword());
    }

    @DeleteMapping("customers/{id}")
    public @ResponseBody
    HttpStatus deleteCustomer(@PathVariable("id") Long id) {
        try {
            customerService.deleteCustomer(id);
        } catch (EmptyResultDataAccessException e) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }


}
