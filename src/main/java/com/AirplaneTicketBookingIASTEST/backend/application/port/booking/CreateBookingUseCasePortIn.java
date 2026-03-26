package com.AirplaneTicketBookingIASTEST.backend.application.port.booking;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.booking.Booking;

public interface CreateBookingUseCasePortIn {

    public Booking save(Booking booking);
}
