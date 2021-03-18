package com.aureus.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication	
@EnableJpaRepositories
public class AureusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AureusApplication.class, args);
	}

}
