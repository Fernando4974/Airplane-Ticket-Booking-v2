package com.AirplaneTicketBookingIASTEST.backend.domain.model.user;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.InvalidLenghtArguments;
import lombok.Getter;

@Getter
public class User {
   private Long id;
   private String name;
   private String lastname;// refactor Object Value
   private UserEmail email; // primer ObjectValue que hago :,)
   private String password;

    public User(
            Long id,
            String name,
            String lastname,
            UserEmail email,
            String password
    ) {
        this.validateField(name,"User name");
        this.validateField(lastname,"User lastname");
        this.validateField(password,"User password");

        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
    private void validateField(String value, String fieldValue){
        if (value == null || value.isBlank() || value.length() > 30 ){
            throw new InvalidLenghtArguments(fieldValue);
        }

    }
}
