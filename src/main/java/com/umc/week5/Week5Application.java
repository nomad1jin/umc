package com.umc.week5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week5Application {

	public static void main(String[] args) {
		SpringApplication.run(Week5Application.class, args);
	}

}
