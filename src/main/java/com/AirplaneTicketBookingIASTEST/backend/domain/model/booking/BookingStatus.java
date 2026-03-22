package com.AirplaneTicketBookingIASTEST.backend.domain.model.booking;

public enum BookingStatus {
    CONFIRMED, PENDING, CANCELLED, COMPLETED;

    public boolean isConfirmed(){
        return this == CONFIRMED;
    }
    public boolean isPending(){
        return this == PENDING;
    }
    public boolean isCancelled(){
        return this == CANCELLED;
    }
    public boolean isCompleted(){
        return this == COMPLETED;
    }
}
