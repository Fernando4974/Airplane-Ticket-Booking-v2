package com.AirplaneTicketBookingIASTEST.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);
//		System.out.println("DEBUG - Puerto cargado: " + System.getenv("SERVER_PORT"));
//		System.out.println("DEBUG - URL DB: " + System.getenv("DB_URL"));
	}

}
