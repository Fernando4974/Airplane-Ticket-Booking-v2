package com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.TicketRepositoryPortOut;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence.JpaTicketRepository;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence.entities.TicketEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JpaTicketImplAdapter implements TicketRepositoryPortOut {
    private final JpaTicketRepository jpaTicketRepository;

    public JpaTicketImplAdapter(JpaTicketRepository jpaTicketRepository) {
        this.jpaTicketRepository = jpaTicketRepository;
    }


    @Override
    public Ticket save(Ticket ticket) {
        final TicketEntity ticketToSave = new TicketEntity(
                null,
                ticket.getTicketCode(),
                ticket.getPassengerDNI(),
                LocalDateTime.now(),
                ticket.getPrice()
        );
        TicketEntity ticketSaved = this.jpaTicketRepository.save(ticketToSave);
        return new Ticket(
                ticketSaved.getId(),
                ticketSaved.getTicketCode(),
                ticketSaved.getPassengerDNI(),
                ticketSaved.getCreatedDate(),
                ticketSaved.getPrice()
        );
    }

    @Override
    public Optional<Ticket> findById() {
        return Optional.empty();
    }


    @Override
    public Optional<Ticket> findByTicketCode(String ticketCode) {
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
