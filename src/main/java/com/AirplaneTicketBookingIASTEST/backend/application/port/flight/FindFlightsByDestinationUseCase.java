package com.AirplaneTicketBookingIASTEST.backend.application.port.in.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;

import java.util.List;
import java.util.Optional;

public interface FindFlightsByDestinationUseCase {
    List<Flight> execute(String destination);
}
