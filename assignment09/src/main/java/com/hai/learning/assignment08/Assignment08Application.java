package com.hai.learning.assignment08;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Assignment08Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment08Application.class, args);
    }

    // Cross-Origin
    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080");
            }
        };
    }

    // ModelMapper
    @Bean
    public ModelMapper initModelMapper() {
        return new ModelMapper();
    }


}
