package com.soen343.salonapp.service.impl;

import com.soen343.salonapp.entity.Customer;
import com.soen343.salonapp.repository.CustomerRepository;
import com.soen343.salonapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    // aggregate
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    // one by id
    @Override
    public Optional<Customer> findCustomer(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> createCustomer(Customer customer) {
        if (customerExistsByUserName(customer.getUsername())) {
            return Optional.empty();
        }
        return Optional.of(customerRepository.save(customer));
    }

    @Override
    public boolean customerExistsByUserName(String username) {
        return customerRepository.existsCustomerByUsername(username);
    }

    // check if exists with username and password (exact match)
    @Override
    public boolean customerExistsByUserNameAndPassword(String username, String password) {
        return customerRepository.existsCustomerByUsernameAndPassword(username, password);
    }

    // delete by id
    @Override
    public void deleteCustomer(Long id) throws EmptyResultDataAccessException {
        customerRepository.deleteById(id);
    }
}
