package com.hai.learning.finalexam02;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FinalExam02Application {

	public static void main(String[] args) {
		SpringApplication.run(FinalExam02Application.class, args);

	}

	// Model Mapper
	@Bean
	public ModelMapper initModelMapper() {
		return new ModelMapper();
	}

}
