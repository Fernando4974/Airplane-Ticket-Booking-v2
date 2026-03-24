package com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence.entities;


import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.UserEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


    public static UserEntity fromDomain(User user) {
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getLastname(),
                user.getEmail().value(),
                user.getPassword()
        );
    }
        public User toDomain() {
            return new User(
                    this.id,
                    this.name,
                    this.lastname,
                    new UserEmail(this.email),
                    this.password
            );
        }
    }
