package com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.InvalidLengthArguments;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.booking.Booking;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Ticket {
    private Long id;
    private String ticketCode;
    private String passengerDNI; //
    private LocalDateTime createdDate;
    private BigDecimal price;



    public void setTicketCode() {
        this.ticketCode = UUID.randomUUID().toString();
    }

//implemantdo en JPAadapter
    public Ticket(Long id, String passengerDNI, LocalDateTime createdDate, String ticketCode, BigDecimal price
    ) {
        this.id = id;
        this.passengerDNI = passengerDNI;
        this.createdDate = createdDate;
        this.price = price;

        this.generateTicketCode();

    }

    public Ticket( String passengerDNI, BigDecimal price) {
        this.validField( passengerDNI );
        this.passengerDNI = passengerDNI;
        this.createdDate = LocalDateTime.now();
        this.price = price;

        this.generateTicketCode();


    }

    private void validField(String value) {

        if (value == null || value.isBlank() || value.length() > 30)
            throw new InvalidLengthArguments("Passenger DIN");

    }

    public void generateTicketCode(){

        this.ticketCode = "TKT-" + UUID.randomUUID()
                .toString().
                substring(0,8);
    }
    public Ticket() {}
}
