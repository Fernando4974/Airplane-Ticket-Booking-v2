package com.AirplaneTicketBookingIASTEST.backend.infraestructure.persistence;

import com.AirplaneTicketBookingIASTEST.backend.infraestructure.persistence.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFlightRepository extends JpaRepository<FlightEntity, Long> {



}
