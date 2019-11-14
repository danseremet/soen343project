package com.soen343.salonapp.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity()
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SalonService extends AbstractBaseEntity {

    private String name;

    SalonService(String name) {
        this.name = name;
    }
}
