package com.example.claimsure_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClaimsureBackendApplication {

	public static void main(String[] args) {
		System.out.println(" Using H2 In-Memory Database");
		SpringApplication.run(ClaimsureBackendApplication.class, args);
	}

}
