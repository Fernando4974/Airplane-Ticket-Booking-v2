package com.AirplaneTicketBookingIASTEST.backend.domain.port;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightRepositoryPort {
    Flight save(Flight flight);
    Optional<Flight> findById(Long id);
    Optional<Flight> findByFlightNumber(String numberFlight);
    List<Flight> findAll();
    List<Flight> findByDestination();
    Flight update(Flight flight);
}
