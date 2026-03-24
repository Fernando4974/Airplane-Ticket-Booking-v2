package com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPortIn;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence.JpaFlightRepository;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence.entities.FlightEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaFlightImplIn implements FlightRepositoryPortIn {
    private final JpaFlightRepository jpaFlightRepository;


    @Override
    public Flight save(Flight flight){

       final FlightEntity flightEntity = new FlightEntity(
                null,
                flight.getFlightNumber(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getLeavedTime(),
                flight.getArrivedTime(),
               flight.getTotalSeats(),
                flight.getPrice()


        );
        FlightEntity flightEntitySaved = jpaFlightRepository.save(flightEntity);
        return new Flight(
                flightEntitySaved.getId(),
                flightEntitySaved.getFlightNumber(),
                flightEntitySaved.getOrigin(),
                flightEntitySaved.getDestination(),
                flightEntitySaved.getLeavedTime(),
                flightEntitySaved.getArrivedTime(),
                flightEntitySaved.getTotalSeats(),
                flightEntitySaved.getPrice()

        );




    }

    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Flight> findByFlightNumber(String numberFlight) {
        return Optional.empty();
    }

    @Override
    public List<Flight> findAll() {
        return List.of();
    }

    @Override
    public List<Flight> findByDestination() {
        return List.of();
    }

    @Override
    public Flight update(Flight flight) {
        return null;
    }
}
