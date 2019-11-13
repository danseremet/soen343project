package com.soen343.salonapp.service.impl;

import com.soen343.salonapp.entity.Customer;
import com.soen343.salonapp.repository.CustomerRepository;
import com.soen343.salonapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Customer getCustomer(Long id) {
        return customerRepository.getOne(id);
    }

    // check if exists
    @Override
    public boolean customerExistsByUserNameAndPassword(Customer customer) {
        ExampleMatcher nameAndPasswordMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("username", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.EXACT))
                .withMatcher("password", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.EXACT));
        Example<Customer> customerExample = Example.of(customer, nameAndPasswordMatcher);
        return customerRepository.exists(customerExample);
    }

    @Override
    public void deleteCustomer(Long id) throws EmptyResultDataAccessException {
        customerRepository.deleteById(id);
    }
}
