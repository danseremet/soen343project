package com.soen343.salonapp.entity;

import lombok.AccessLevel;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends AbstractUser {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )
    private Integer id;

    public Customer(String username, String password, String email, String firstName, String lastName) {
        super(username, password, email, firstName, lastName);
    }

}
