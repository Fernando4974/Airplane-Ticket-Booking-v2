package com.AirplaneTicketBookingIASTEST.backend.application.service.ticket;

import com.AirplaneTicketBookingIASTEST.backend.application.exception.BusinessException;
import com.AirplaneTicketBookingIASTEST.backend.application.port.ticket.TicketUseCasesPortIn;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.dto.request.ticket.RequestTicketDto;

import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.dto.response.ResponseTicketDto;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.TicketRepositoryPortOut;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.mapper.ticket.TicketResMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class TicketServicesImplPortIn implements TicketUseCasesPortIn {
    public final TicketRepositoryPortOut ticketRepositoryPortOut;



    @Override
    public Ticket createTicket(Ticket newTicket) {
    log.info("TRANSACTION STARTING / Create Ticket");
        //refactor
    try {

        //revisar este Setter

        newTicket.generateTicketCode();


        ticketRepositoryPortOut.findByTicketCode(newTicket.getTicketCode())
                .ifPresent(exist ->{
            throw new BusinessException("Ticket is already Exist");
        });

        Ticket savedTicket = ticketRepositoryPortOut.save(newTicket);

        log.info("Ticket Saved Successfully. Code: {}", savedTicket.getTicketCode());
        return savedTicket;




    }catch (BusinessException e){
        log.warn("TRANSACTION FAIL / Create Ticket fail by: {}", String.valueOf(e));
        throw e;
    } catch (RuntimeException e) {
        log.error("MASSIVE FAIL / Inside Fail Creating the ticket by: ${}", e.getMessage());
        throw new RuntimeException(e);
    }

    }


}
