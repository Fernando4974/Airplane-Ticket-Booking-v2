package com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.InvalidLenghtArguments;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class Ticket {
    private Long id;
    private Flight flight;
    private User user;
    private String passengerDNI; //
    private String booking; // ME falta crear booking
    private LocalDateTime createdDate;
    private BigDecimal price;


    public Ticket(

            Flight flight,
            User user,
            String passengerDNI,
            String booking,
            BigDecimal price

    ) {
        this.validField( passengerDNI );

        this.flight = flight;
        this.user = user;
        this.passengerDNI = passengerDNI;
        this.booking = booking;
        this.createdDate = LocalDateTime.now();
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private void validField(String value){

        if (value == null || value.isBlank() || value.length() > 30)
            throw  new InvalidLenghtArguments("Passenger DIN");

    }
}
