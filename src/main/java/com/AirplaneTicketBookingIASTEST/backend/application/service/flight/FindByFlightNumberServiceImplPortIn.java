package com.AirplaneTicketBookingIASTEST.backend.application.service.flight;

import com.AirplaneTicketBookingIASTEST.backend.application.exception.FlightException;
import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.FindFlightByFlightNumberUseCasePortIn;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.FoundFlightDtoRequest;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindByFlightNumberServiceImplPortIn implements FindFlightByFlightNumberUseCasePortIn {
    private final FlightRepositoryPortOut flightRepositoryPortOut;

    @Override
    public FoundFlightDtoRequest execute(String flightNumber){

        Flight foundFlight = this.flightRepositoryPortOut.findByFlightNumber(flightNumber)
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
