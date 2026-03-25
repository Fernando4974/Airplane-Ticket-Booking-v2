package com.AirplaneTicketBookingIASTEST.backend.application.service.ticket;

import com.AirplaneTicketBookingIASTEST.backend.application.exception.BusinessException;
import com.AirplaneTicketBookingIASTEST.backend.application.port.ticket.TicketUseCases;
import com.AirplaneTicketBookingIASTEST.backend.application.service.ticket.dto.RequestTicketDto;

import com.AirplaneTicketBookingIASTEST.backend.application.service.ticket.dto.ResponseTicketDto;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.TicketRepositoryPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class TicketServices implements TicketUseCases {
    public final TicketRepositoryPortOut ticketRepositoryPortOut;



    @Override
    public ResponseTicketDto createTicket(RequestTicketDto requestTicketDto) {
    log.info("TRANSACTION STARTING / Create Ticket");

    try {

        Ticket newTicket = new Ticket(
                requestTicketDto.getPassengerDNI(),
                requestTicketDto.getPrice()
        );
        //revisar este Setter
        newTicket.setTicketCode();
        this.ticketRepositoryPortOut.findByTicketCode(newTicket.getTicketCode()).ifPresent(exist ->{
            throw new BusinessException("Ticket is already Exist");
        });


        Ticket savedTicket = ticketRepositoryPortOut.save(newTicket);
        log.info("Ticket Saved Successful Code#: ${}",savedTicket.getTicketCode());
        return new ResponseTicketDto(
                savedTicket.getId(),
                savedTicket.getPassengerDNI(),
                savedTicket.getCreatedDate(),
                savedTicket.getPrice()
        );
    }catch (BusinessException e){
        log.warn("TRANSACTION FAIL / Create Ticket fail by: {}", String.valueOf(e));
        throw e;
    } catch (RuntimeException e) {
        log.error("MASSIVE FAIL / Inside Fail Creating the ticket by: ${}", e.getMessage());
        throw new RuntimeException(e);
    }

    }

    @Override
    public RequestTicketDto deleteTicket(String id) {
        return null;
    }
}
