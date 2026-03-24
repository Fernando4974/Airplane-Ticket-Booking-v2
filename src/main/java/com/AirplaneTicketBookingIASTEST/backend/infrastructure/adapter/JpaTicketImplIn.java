package com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.TicketRepositoryPortIn;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence.JpaTicketRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaTicketImplIn implements TicketRepositoryPortIn {
    private final JpaTicketRepository jpaTicketRepository;

    public JpaTicketImplIn(JpaTicketRepository jpaTicketRepository) {
        this.jpaTicketRepository = jpaTicketRepository;
    }


    @Override
    public Ticket save(Ticket ticket) {
        return null;
    }

    @Override
    public Optional<Ticket> findById() {
        return Optional.empty();
    }

    @Override
    public List<Ticket> findAll() {
        return List.of();
    }

    @Override
    public Ticket update(Ticket ticket) {
        return null;
    }
}
