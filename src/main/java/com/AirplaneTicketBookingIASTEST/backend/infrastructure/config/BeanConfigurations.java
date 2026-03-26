package com.AirplaneTicketBookingIASTEST.backend.infrastructure.config;

import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.CreateFlightUseCasePortIn;
import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.FindFlightByFlightNumberUseCasePortIn;
import com.AirplaneTicketBookingIASTEST.backend.application.port.ticket.TicketUseCasesPortIn;
import com.AirplaneTicketBookingIASTEST.backend.application.port.user.UserUseCases;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.CreateFlightServiceImplPortIn;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.FindByFlightNumberServiceImplPortIn;
import com.AirplaneTicketBookingIASTEST.backend.application.service.ticket.TicketServicesImplPortIn;
import com.AirplaneTicketBookingIASTEST.backend.application.service.user.UserServices;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPortOut;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.TicketRepositoryPortOut;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.UserRepositoryPortOut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {
    @Bean
    public CreateFlightUseCasePortIn createFlightUseCase(FlightRepositoryPortOut flightRepositoryPortOut){
        return new CreateFlightServiceImplPortIn(flightRepositoryPortOut);
    }
    @Bean
    public FindFlightByFlightNumberUseCasePortIn findFlightByFlightNumberUseCase(FlightRepositoryPortOut flightRepositoryPortOut){
        return new FindByFlightNumberServiceImplPortIn(flightRepositoryPortOut);
    }
    @Bean
    public UserUseCases userUseCases(UserRepositoryPortOut userRepositoryPortOut){
        return new UserServices(userRepositoryPortOut);
    }
    @Bean
    TicketUseCasesPortIn ticketUseCases(TicketRepositoryPortOut ticketRepositoryPortOut){
        return new TicketServicesImplPortIn(ticketRepositoryPortOut);
    }
}
