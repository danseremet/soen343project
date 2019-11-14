package com.soen343.salonapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Booking extends AbstractBaseEntity {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @ManyToOne
    private Salon salon;

    @OneToOne
    private Customer customer;

    private boolean paid;

    public Booking(LocalDateTime startTime, LocalDateTime endTime, Salon salon, Customer customer) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.salon = salon;
        this.customer = customer;
        this.paid = false;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getSalonId() {
        return salon.getId();
    }

    @JsonIgnore
    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Long getCustomerId() {
        return customer.getId();
    }

    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {

        if (paid) {
            return "Booking Deatils: \\" +
                    "Salon: " + salon.getName() +
                    "\\Start Time: " + startTime +
                    "\\End Time: " + endTime +
                    "\\Client Name: " + customer.getFirstName() + " " + customer.getLastName() +
                    "\\Payment: paid online";
        } else {
            return "Booking Deatils: \\" +
                    "Salon: " + salon.getName() +
                    "\\Start Time: " + startTime +
                    "\\End Time: " + endTime +
                    "\\Client Name: " + customer.getFirstName() + " " + customer.getLastName() +
                    "\\Payment: pay in salon on appointment day";
        }
    }

}
