package com.yosaco.uptropy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class UptropyApplication {

	public static void main(String[] args) {
		SpringApplication.run(UptropyApplication.class, args);
	}

}
