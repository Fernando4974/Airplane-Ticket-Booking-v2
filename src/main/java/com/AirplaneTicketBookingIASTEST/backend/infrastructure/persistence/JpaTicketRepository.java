package com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence;

import com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTicketRepository extends JpaRepository<TicketEntity, Long> {

}
