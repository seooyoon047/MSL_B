package com.example.msl_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication

public class MslBApplication {

	public static void main(String[] args) {
		SpringApplication.run(MslBApplication.class, args);
	}

}
