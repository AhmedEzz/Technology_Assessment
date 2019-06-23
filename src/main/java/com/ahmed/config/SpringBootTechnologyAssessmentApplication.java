package com.ahmed.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.ahmed.*")
@EnableWebMvc
public class SpringBootTechnologyAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTechnologyAssessmentApplication.class, args);
	}

}
