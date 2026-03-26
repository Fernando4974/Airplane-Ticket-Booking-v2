package com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.mapper.ticket;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.dto.response.ResponseTicketDto;

public class TicketResMapper {
    public static ResponseTicketDto toResponse(Ticket ticket){
        if (ticket == null) return null;

        return new ResponseTicketDto(
                ticket.getId(),
                ticket.getTicketCode(),
                ticket.getPassengerDNI(),
                ticket.getCreatedDate(),
                ticket.getPrice()
        );
    }
}
