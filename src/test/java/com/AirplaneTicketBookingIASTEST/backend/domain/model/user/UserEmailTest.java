package com.AirplaneTicketBookingIASTEST.backend.domain.model.user;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.InvalidLengthArguments;
import com.AirplaneTicketBookingIASTEST.backend.domain.exception.user.InvalidEmailException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserEmailTest {
    @Test
    @DisplayName("Should throw a exception if send a email without @")
    void ShouldThrowExceptionWhenEmailDoNotHaveCorrectFormat(){
        assertThrows(InvalidEmailException.class, ()->{
            new UserEmail("fernando.com");
        });
    }
    @Test
    @DisplayName("Should throw exception when email is too lenght")
    void ShouldThrowExceptionWhenEmailIsToLong(){
        assertThrows(InvalidLengthArguments.class, ()->{
            new UserEmail("OnlyCreatedByTestingReason@email.com");
        });
    }

}