package com.AirplaneTicketBookingIASTEST.backend.application.port.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;

import java.util.List;

public interface FindFlightsByDestinationUseCasePortIn {
    List<Flight> execute(String destination);
}
