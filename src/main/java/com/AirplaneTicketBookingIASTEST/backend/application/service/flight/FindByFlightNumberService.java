package com.AirplaneTicketBookingIASTEST.backend.application.service.flight;

import com.AirplaneTicketBookingIASTEST.backend.application.exception.FlightException;
import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.FindFlightByFlightNumberUseCase;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.FoundFlightDtoRequest;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPortIn;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindByFlightNumberService implements FindFlightByFlightNumberUseCase {
    private final FlightRepositoryPortIn flightRepositoryPortIn;

    @Override
    public FoundFlightDtoRequest execute(String flightNumber){

        Flight foundFlight = this.flightRepositoryPortIn.findByFlightNumber(flightNumber)
                .orElseThrow(()-> new FlightException("Flight not found"));

        return new FoundFlightDtoRequest(
                foundFlight.getId(),
                foundFlight.getFlightNumber(),
                foundFlight.getOrigin(),
                foundFlight.getDestination(),
                foundFlight.getLeavedTime(),
                foundFlight.getArrivedTime(),
                foundFlight.getTotalSeats(),
                foundFlight.getOccupiedSeats(),
                foundFlight.getFlightStatus(),
                foundFlight.getPrice()
        );
    }

}
