package com.soen343.salonapp.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends AbstractUser {

    public Customer(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }
}
