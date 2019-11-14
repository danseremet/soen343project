package com.soen343.salonapp.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SalonOwner extends AbstractUser {

    public SalonOwner(String username, String password, String email, String firstName, String lastName) {
        super(username, password, email, firstName, lastName);
    }
}
