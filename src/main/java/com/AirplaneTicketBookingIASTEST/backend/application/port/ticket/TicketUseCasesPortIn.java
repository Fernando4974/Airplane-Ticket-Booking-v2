package com.AirplaneTicketBookingIASTEST.backend.application.port.ticket;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.dto.response.ResponseTicketDto;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.dto.request.ticket.RequestTicketDto;



public interface TicketUseCasesPortIn {
    Ticket createTicket(Ticket ticket);

}
