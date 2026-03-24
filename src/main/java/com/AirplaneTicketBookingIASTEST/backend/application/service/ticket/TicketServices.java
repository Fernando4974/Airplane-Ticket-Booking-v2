package com.AirplaneTicketBookingIASTEST.backend.application.service.ticket;

import com.AirplaneTicketBookingIASTEST.backend.application.port.ticket.TicketUseCases;
import com.AirplaneTicketBookingIASTEST.backend.application.service.ticket.dto.RequestTicketDto;

import com.AirplaneTicketBookingIASTEST.backend.application.service.ticket.dto.ResponseTicketDto;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.TicketRepositoryPortIn;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicketServices implements TicketUseCases {
    public final TicketRepositoryPortIn ticketRepositoryPortIn;
    @Override
    public ResponseTicketDto createTicket(RequestTicketDto requestTicketDto) {

        Ticket newTicket = new Ticket(
                requestTicketDto.getPassengerDNI(),
                requestTicketDto.getPrice()
        );
        Ticket savedTicket = ticketRepositoryPortIn.save(newTicket);

        return new ResponseTicketDto(
                savedTicket.getId(),
                savedTicket.getPassengerDNI(),
                savedTicket.getCreatedDate(),
                savedTicket.getPrice()
        );

    }

    @Override
    public RequestTicketDto deleteTicket(String id) {
        return null;
    }
}
