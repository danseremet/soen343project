package com.soen343.salonapp.service;


import com.soen343.salonapp.entity.Customer;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer getCustomer(Long id);

    // check if exists
    boolean customerExistsByUserNameAndPassword(Customer customer);

    void deleteCustomer(Long id) throws EmptyResultDataAccessException;
}
