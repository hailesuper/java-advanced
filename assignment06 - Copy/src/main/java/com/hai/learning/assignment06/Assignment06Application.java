package com.hai.learning.assignment06;

import com.hai.learning.assignment06.repository.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EntityScan( basePackages = {"com.hai.learning.assignment06.entity"} )
public class Assignment06Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Assignment06Application.class, args);
		System.out.println(context.getBean(DepartmentRepository.class));
	}

}
