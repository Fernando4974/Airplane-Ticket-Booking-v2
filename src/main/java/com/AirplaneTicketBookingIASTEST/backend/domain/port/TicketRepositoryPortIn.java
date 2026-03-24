package com.AirplaneTicketBookingIASTEST.backend.domain.port;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepositoryPortIn {
    Ticket save(Ticket ticket);
    Optional<Ticket> findById();
    List<Ticket> findAll();
    Ticket update(Ticket ticket);
}
