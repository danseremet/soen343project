package com.soen343.salonapp.repository;

import com.soen343.salonapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsCustomerByUsername(String username);

    boolean existsCustomerByUsernameAndPassword(String username, String password);
}
