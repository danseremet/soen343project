package com.soen343.salonapp.service;


import com.soen343.salonapp.entity.Customer;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getCustomers();

    // one by id
    Optional<Customer> findCustomer(Long id);

    Optional<Customer> createCustomer(Customer customer);

    boolean customerExistsByUserName(String username);

    // check if exists with username and password (exact match)
    boolean customerExistsByUserNameAndPassword(String username, String password);

    void deleteCustomer(Long id) throws EmptyResultDataAccessException;
}
