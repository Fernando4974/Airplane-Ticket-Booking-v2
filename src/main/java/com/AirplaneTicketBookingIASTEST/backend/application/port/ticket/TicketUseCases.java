package com.AirplaneTicketBookingIASTEST.backend.application.port.ticket;

import com.AirplaneTicketBookingIASTEST.backend.application.service.ticket.dto.ResponseTicketDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.ticket.dto.RequestTicketDto;


public interface TicketUseCases{

    ResponseTicketDto createTicket(RequestTicketDto requestTicketDto);
    RequestTicketDto deleteTicket(String id);
}
