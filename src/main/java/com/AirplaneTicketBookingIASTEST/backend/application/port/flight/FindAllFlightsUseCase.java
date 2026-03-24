package com.AirplaneTicketBookingIASTEST.backend.application.port.in.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;

import java.util.List;

public interface FindAllFlightsUseCase {
    List<Flight> findAll();
}
