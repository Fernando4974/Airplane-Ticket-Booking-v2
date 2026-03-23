package com.AirplaneTicketBookingIASTEST.backend.domain.model.flight;

public enum FlightStatus {
    ON_TIME("On time"),
    CANCELLED("Canceled"),
    COMPLETED("Completed"),
    DELAYED("Delayed");

    private final String description;

    FlightStatus(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public boolean allowCheckIn() {
        return this == ON_TIME || this == DELAYED;
    }
}