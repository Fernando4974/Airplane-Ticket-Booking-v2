package com.AirplaneTicketBookingIASTEST.backend.domain.model.user;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.InvalidLenghtArguments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
   @DisplayName("Should create a user with valid data")
    void ShouldCreateUserWhitValidData(){
        Long id = 1L;
        String name = "Fernando";
        String lastname = "Villarreal";
        UserEmail userEmail = new UserEmail("fernando@gmail.com");
        String password = "password123";

        User user = new User(id,name,lastname,userEmail,password);

        assertAll(
                () -> assertEquals(id, user.getId()),
                () -> assertEquals(name, user.getName()),
                () -> assertEquals(lastname, user.getLastname()),
                () -> assertEquals(userEmail, user.getEmail()),
                () -> assertTrue(user.getPassword().length() <= 30)
        );
    }
    @Test
    @DisplayName("Should Not created if password is more long than 30")
    void ShouldThrowExceptionWhenPasswordIsTooLong(){
        UserEmail userEmail = new UserEmail("fernando@fer.com");
        assertThrows(InvalidLenghtArguments.class,()->
                new User(
                        1L,
                        "Fernando",
                        "Villarreal",
                        userEmail,
                        "passwordtestecxedesthirtencharacteres")
        );
    }
}