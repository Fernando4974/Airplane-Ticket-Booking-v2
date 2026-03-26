package com.AirplaneTicketBookingIASTEST.backend.domain.port;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.booking.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepositoryPortOut {
    Booking save(Booking booking);
    Optional<Booking>FindById(Long id);
    List<Booking>FindAll();
    Booking update(Booking booking);
}
