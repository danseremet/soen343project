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
public class SalonOwner extends AbstractUser{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )
    private Integer id;

    public SalonOwner(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }

}
