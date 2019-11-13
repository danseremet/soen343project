package com.soen343.salonapp.controller;

import com.soen343.salonapp.entity.Customer;
import com.soen343.salonapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers/{id}")
    public @ResponseBody Customer getCustomer(@PathVariable("id") Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/customers")
    public @ResponseBody List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/customer/exists")
    public @ResponseBody Boolean customerExists(@RequestBody Customer customer) {
        return customerService.customerExistsByUserNameAndPassword(customer);
    }

    @DeleteMapping("customers/{id}")
    public @ResponseBody HttpStatus deleteCustomer(@PathVariable("id") Long id) {
        try {
            customerService.deleteCustomer(id);
        } catch (EmptyResultDataAccessException e) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }




}
