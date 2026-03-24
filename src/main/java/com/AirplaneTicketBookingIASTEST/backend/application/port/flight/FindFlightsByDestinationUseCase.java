package com.AirplaneTicketBookingIASTEST.backend.application.port.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;

import java.util.List;
import java.util.Optional;

public interface FindFlightsByDestinationUseCase {
    List<Flight> execute(String destination);
}
