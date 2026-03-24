package com.AirplaneTicketBookingIASTEST.backend.domain.model.booking;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.booking.EmptyTicketListException;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Booking {
    private Long id;
    private Long userId;
    private String flightNumber;
    private List<Ticket> ticketList = new ArrayList<>();
    private LocalDateTime bookingDate;
    private BookingStatus bookingStatus;

    public Booking(Long userId, String flightNumber) {

        if (userId <= 0 || flightNumber.isEmpty()) throw new IllegalArgumentException("User and Flight are required");

        this.userId = userId;
        this.flightNumber = flightNumber;
        this.bookingDate = LocalDateTime.now();
        this.bookingStatus = BookingStatus.PENDING;
    }


    public  List<Ticket> getTicketList() {
        if (this.ticketList.isEmpty()){
            throw new EmptyTicketListException();
        }
        return Collections.unmodifiableList(ticketList); // if try update from exit class throw UnsupportedOperationException.
    }

    public void addTicket(Ticket ticket) {
        if (ticket == null) throw new IllegalArgumentException("Ticket cannot be null"); // refactor exception
        this.ticketList.add(ticket);
    }

    public BigDecimal getTotalAmount() {
        if (this.ticketList.isEmpty()){
            throw new EmptyTicketListException();
        }
        return ticketList.stream()
                .map(Ticket::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}