package com.AirplaneTicketBookingIASTEST.backend.application.service.booking;

import com.AirplaneTicketBookingIASTEST.backend.application.exception.FlightException;
import com.AirplaneTicketBookingIASTEST.backend.application.port.booking.CreateBookingUseCasePortIn;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.booking.Booking;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.FlightStatus;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.BookingRepositoryPortOut;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPortOut;
import org.springframework.transaction.annotation.Transactional;

public class CreateBookingImplService implements CreateBookingUseCasePortIn {
    final private BookingRepositoryPortOut bookingRepositoryPortOut;
    final private FlightRepositoryPortOut flightRepositoryPortOut;

    public CreateBookingImplService(BookingRepositoryPortOut bookingRepositoryPortOut, FlightRepositoryPortOut flightRepositoryPortOut) {
        this.bookingRepositoryPortOut = bookingRepositoryPortOut;
        this.flightRepositoryPortOut =  flightRepositoryPortOut;

    }


    @Override
    @Transactional
    public Booking save(Booking booking) {

        Flight flight = this.flightRepositoryPortOut.findByFlightNumber(booking.getFlightNumber())
                .orElseThrow( ()-> new FlightException("Flight Not found"));

           if ( FlightStatus.CANCELLED.equals(flight.getFlightStatus())){
               throw new RuntimeException("The Flight was Cancelled");
           }

           int occupiedSeats = flight.getOccupiedSeats();
           int availableSeats = flight.getTotalSeats()-occupiedSeats;

           if (booking.getTicketList().size() > availableSeats){
               throw new RuntimeException(String
                       .format("This Flight does not have enough seats available, Available seats :%d",
                               flight.getTotalSeats()-occupiedSeats));
           }

           int requiredSeats = booking.getTicketList().size();
           flight.setOccupiedSeats(flight.getOccupiedSeats() + requiredSeats);


           flightRepositoryPortOut.save(flight);
           return this.bookingRepositoryPortOut.save(booking);


    }
}
