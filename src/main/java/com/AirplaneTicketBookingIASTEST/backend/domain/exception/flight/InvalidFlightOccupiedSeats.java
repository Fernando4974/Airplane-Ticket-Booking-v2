package com.AirplaneTicketBookingIASTEST.backend.domain.exception.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.BusinessException;

public class InvalidFlightOccupiedSeats extends BusinessException {
    public InvalidFlightOccupiedSeats() {
        super("Occupied Seats can not exceed the total number of seats");
    }
}
