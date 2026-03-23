package com.AirplaneTicketBookingIASTEST.backend.domain.model.user;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.InvalidLenghtArguments;
import com.AirplaneTicketBookingIASTEST.backend.domain.exception.user.InvalidEmailException;

public record UserEmail(String value) {
    private static final  String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    public UserEmail {
        if (value == null || value.isBlank() || !value.matches(EMAIL_REGEX)){
            throw new InvalidEmailException();
        };
        if (value.length() > 30){
            throw  new InvalidLenghtArguments("User email");
        }
    }
}
