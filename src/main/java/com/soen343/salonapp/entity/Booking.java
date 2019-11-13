package com.soen343.salonapp.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Booking {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )
    private Integer id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Salon salon;
    private Customer customer;
    private boolean paymentMade;

    public Booking(LocalDateTime startTime, LocalDateTime endTime, Salon salon, Customer customer) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.salon = salon;
        this.customer = customer;
        this.paymentMade = false;
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

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isPaymentMade() {
        return paymentMade;
    }

    public void setPaymentMade(boolean paymentMade) {
        this.paymentMade = paymentMade;
    }

    @Override
    public String toString() {

        if (paymentMade) {
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
