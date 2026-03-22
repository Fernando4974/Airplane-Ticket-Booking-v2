package com.AirplaneTicketBookingIASTEST.backend.domain.model.booking;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor
public class Booking {
    private Long id;
    private User user;
    private Flight flight;
    private List<Ticket> ticketList = new ArrayList<>();
    private LocalDateTime bookingDate;
    private BookingStatus bookingStatus;

    public Booking(User user, Flight flight) {

        if (user == null || flight == null) throw new IllegalArgumentException("User and Flight are required");

        this.user = user;
        this.flight = flight;
        this.bookingDate = LocalDateTime.now();
        this.bookingStatus = BookingStatus.PENDING;
    }


    public List<Ticket> getTicketList() {
        return Collections.unmodifiableList(ticketList); // if try update from exit class throw UnsupportedOperationException.
    }

    public void addTicket(Ticket ticket) {
        if (ticket == null) throw new IllegalArgumentException("Ticket cannot be null"); // refactor exception
        this.ticketList.add(ticket);
    }

    public BigDecimal getTotalAmount() {
        return ticketList.stream()
                .map(Ticket::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}