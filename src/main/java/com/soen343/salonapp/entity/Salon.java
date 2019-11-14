package com.soen343.salonapp.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Salon extends AbstractBaseEntity {

    private String name;

    @ManyToOne
    private SalonOwner owner;

    @ElementCollection(targetClass = SalonService.class)
    @Enumerated(EnumType.STRING)
    private List<SalonService> availableServices;

    public Salon(String name, SalonOwner owner) {
        this.name = name;
        this.owner = owner;
        this.availableServices = new ArrayList<>();
    }

    public Salon(String name, SalonOwner owner, List<SalonService> salonServices) {
        this.name = name;
        this.owner = owner;
        this.availableServices = salonServices;
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

    public List<SalonService> getAvailableServices() {
        return availableServices;
    }

    public void setAvailableServices(List<SalonService> availableServices) {
        this.availableServices = availableServices;
    }

    @Override
    public String toString() {
        return "Salon: " + name + " \\ Owner: " + owner.getFirstName() + " " + owner.getLastName()
                + "\\ Available Salon Services: " + availableServices;
    }
}
