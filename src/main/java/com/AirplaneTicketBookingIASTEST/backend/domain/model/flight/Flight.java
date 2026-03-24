package com.AirplaneTicketBookingIASTEST.backend.domain.model.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.flight.InvalidFlightDateException;
import com.AirplaneTicketBookingIASTEST.backend.domain.exception.flight.InvalidFlightOccupiedSeats;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    private Long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime leavedTime;
    private LocalDateTime arrivedTime;
    private Integer totalSeats;
    private Integer occupiedSeats;
    private FlightStatus flightStatus;
    private BigDecimal price;



    public Flight(
            Long id,
            String flightNumber,
            String origin,
            String destination,
            LocalDateTime leavedTime,
            LocalDateTime arrivedTime,
            Integer totalSeats,
            BigDecimal price

    ) {
        if (totalSeats < 0) {
            throw new InvalidFlightOccupiedSeats();
        }
        if (arrivedTime.isBefore(leavedTime))
            throw new InvalidFlightDateException();
        this.id = id;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.leavedTime = leavedTime;
        this.arrivedTime = arrivedTime;
        this.totalSeats= totalSeats ;
        this.occupiedSeats = 0;
        this.flightStatus = FlightStatus.ON_TIME;
        this.price = price;

    }

    public String getStatusFlightDescription() {
        return this.flightStatus != null ? this.flightStatus.getDescription() : null;
    }

    public void setOccupiedSeats(Integer additionalSeats) {
        int current = (this.occupiedSeats == null) ? 0 : this.occupiedSeats;
        this.occupiedSeats = current + additionalSeats;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }
}

