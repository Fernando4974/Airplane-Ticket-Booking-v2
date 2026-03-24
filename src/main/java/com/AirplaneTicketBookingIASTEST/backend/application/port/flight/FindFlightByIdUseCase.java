package com.AirplaneTicketBookingIASTEST.backend.application.port.in.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;

import java.util.Optional;

public interface FindFlightByIdUseCase {
    Optional<Flight> execute(Long id);
}
