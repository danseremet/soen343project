package com.soen343.salonapp.dto;

import java.time.LocalDateTime;

public class BookingDTO {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long salonId;

    private Long customerId;

    public BookingDTO(LocalDateTime startTime, LocalDateTime endTime, Long salonId, Long customerId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.salonId = salonId;
        this.customerId = customerId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Long getSalonId() {
        return salonId;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
