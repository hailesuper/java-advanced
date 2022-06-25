package com.hai.learning.assignment06spring2;

import com.hai.learning.assignment06spring2.repository.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Assignment06Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Assignment06Application.class, args);
		System.out.println(context.getBean(DepartmentRepository.class));
	}

}
