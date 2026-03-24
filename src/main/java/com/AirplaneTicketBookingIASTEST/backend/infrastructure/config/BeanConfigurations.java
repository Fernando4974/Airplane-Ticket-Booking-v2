package com.AirplaneTicketBookingIASTEST.backend.infrastructure.config;

import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.CreateFlightUseCase;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.CreateFlightService;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPortIn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {
    @Bean
    public CreateFlightUseCase createFlightUseCase(FlightRepositoryPortIn flightRepositoryPortIn){
        return new CreateFlightService(flightRepositoryPortIn);
    }
}
