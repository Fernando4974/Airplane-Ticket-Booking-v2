package com.AirplaneTicketBookingIASTEST.backend.application.service.flight;

import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.CreateFlightUseCase;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CreateFlightServe implements CreateFlightUseCase {

    private final FlightRepositoryPort flightRepositoryPort;


    public CreateFlightServe(FlightRepositoryPort flightRepositoryPort) {
        this.flightRepositoryPort = flightRepositoryPort;
    }
    @Override
    Flight execute(){

    }
}
