package com.soen343.salonapp.repository;

import com.soen343.salonapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsCustomerByUsername(String username);

    boolean existsCustomerByUsernameAndPassword(String username, String password);

    @Query("select c from Customer c where c.username = :username")
    Optional<Customer> findByUsername(@Param("username") String username);
}


