package com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.mapper.ticket;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.dto.request.ticket.RequestTicketDto;

public class TicketReqMapper {
   public static Ticket toDomain(RequestTicketDto requestTicketDto){
       if (requestTicketDto == null) return null;
       return new Ticket(
               requestTicketDto.getPassengerDNI(),
               requestTicketDto.getPrice()
       );
   }
}
