package com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.InvalidLengthArguments;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.booking.Booking;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class Ticket {
    private Long id;
    private String passengerDNI; //
    private LocalDateTime createdDate;
    private BigDecimal price;



    public Ticket(


            String passengerDNI,
            BigDecimal price

    ) {
        this.validField( passengerDNI );

        this.passengerDNI = passengerDNI;
        this.createdDate = LocalDateTime.now();
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private void validField(String value){

        if (value == null || value.isBlank() || value.length() > 30)
            throw  new InvalidLengthArguments("Passenger DIN");

    }
}
