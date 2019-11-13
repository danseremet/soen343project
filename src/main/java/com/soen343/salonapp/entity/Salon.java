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
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Salon {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )
    private Integer id;
    private String name;
    private SalonOwner owner;
    private String services;

    public Salon(String name, SalonOwner owner) {
        this.name = name;
        this.owner = owner;
        this.services = null;
    }

    public Salon(String name, SalonOwner owner, String services) {
        this.name = name;
        this.owner = owner;
        this.services = services;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SalonOwner getOwner() {
        return owner;
    }

    public void setOwner(SalonOwner owner) {
        this.owner = owner;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Salon: " + name + " \\ Owner: " + owner.getFirstName() + " " + owner.getLastName()
                + "\\ Salon Services: " + services;
    }
}
