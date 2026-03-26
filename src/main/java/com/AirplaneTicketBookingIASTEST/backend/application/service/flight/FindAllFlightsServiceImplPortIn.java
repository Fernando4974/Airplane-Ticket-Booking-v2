package com.AirplaneTicketBookingIASTEST.backend.application.service.flight;

import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.FindAllFlightsUseCasePortIn;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.FoundFlightDtoRequest;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPortOut;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllFlightsServiceImplPortIn implements FindAllFlightsUseCasePortIn {
    private final FlightRepositoryPortOut flightRepositoryPortOut;

    public FindAllFlightsServiceImplPortIn(FlightRepositoryPortOut flightRepositoryPortOut) {
        this.flightRepositoryPortOut = flightRepositoryPortOut;
    }

    @Override
    public List<FoundFlightDtoRequest> findAll() {

        List<Flight> flightList = this.flightRepositoryPortOut.findAll();

        return flightList.stream()
                .map(
                        flight ->
                                new FoundFlightDtoRequest(
                                flight.getId(),
                                flight.getFlightNumber(),
                                flight.getOrigin(),
                                flight.getDestination(),
                                flight.getLeavedTime(),
                                flight.getArrivedTime(),
                                flight.getTotalSeats(),
                                flight.getOccupiedSeats(),
                                flight.getFlightStatus(),
                                flight.getPrice()
                                )


                ).collect(Collectors.toList());

    }
}
