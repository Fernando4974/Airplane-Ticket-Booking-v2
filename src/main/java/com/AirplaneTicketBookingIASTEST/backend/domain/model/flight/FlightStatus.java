package com.AirplaneTicketBookingIASTEST.backend.domain.model.flight;

public enum FlightStatus {
    ON_TIME, CANCELLED, COMPLETED;


    public boolean allowCheckIn(){

        return this == ON_TIME;
    }
}
