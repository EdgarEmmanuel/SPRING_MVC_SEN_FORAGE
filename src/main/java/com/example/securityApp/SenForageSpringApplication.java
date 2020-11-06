package com.example.securityApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.securityApp.entities"})
public class SenForageSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenForageSpringApplication.class, args);
	}

}
