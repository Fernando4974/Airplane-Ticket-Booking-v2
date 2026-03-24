package com.AirplaneTicketBookingIASTEST.backend.infrastructure.config;

import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.CreateFlightUseCase;
import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.FindFlightByFlightNumberUseCase;
import com.AirplaneTicketBookingIASTEST.backend.application.port.user.UserUseCases;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.CreateFlightService;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.FindByFlightNumberService;
import com.AirplaneTicketBookingIASTEST.backend.application.service.user.UserServices;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPortIn;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.UserRepositoryPortIn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {
    @Bean
    public CreateFlightUseCase createFlightUseCase(FlightRepositoryPortIn flightRepositoryPortIn){
        return new CreateFlightService(flightRepositoryPortIn);
    }
    @Bean
    public FindFlightByFlightNumberUseCase findFlightByFlightNumberUseCase(FlightRepositoryPortIn flightRepositoryPortIn){
        return new FindByFlightNumberService(flightRepositoryPortIn);
    }
    @Bean
    public UserUseCases userUseCases(UserRepositoryPortIn userRepositoryPortIn){
        return new UserServices(userRepositoryPortIn);
    }
}
