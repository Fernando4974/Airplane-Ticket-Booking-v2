package com.AirplaneTicketBookingIASTEST.backend.domain.model.user;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.InvalidLengthArguments;
import com.AirplaneTicketBookingIASTEST.backend.domain.exception.user.InvalidEmailException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


// Este que es mi primer objectValue se lo dedico a mi novia Kalor Reyes <3
public record UserEmail(@JsonValue String value) {
    private static final  String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    @JsonCreator
    public UserEmail {
        if (value == null || value.isBlank() || !value.matches(EMAIL_REGEX)){
            throw new InvalidEmailException();
        };
        if (value.length() > 30){
            throw  new InvalidLengthArguments("User email");
        }
    }

}
