package com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence;

import com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaFlightRepository extends JpaRepository<FlightEntity, Long> {



}

