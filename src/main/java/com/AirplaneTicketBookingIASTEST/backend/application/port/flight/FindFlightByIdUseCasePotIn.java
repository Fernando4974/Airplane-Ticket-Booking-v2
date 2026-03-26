package com.AirplaneTicketBookingIASTEST.backend.application.port.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;

import java.util.Optional;

public interface FindFlightByIdUseCasePotIn {
    Optional<Flight> execute(Long id);
}
