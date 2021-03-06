package com.tcs.poc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@CrossOrigin("*")
public class DashboardManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardManagementServiceApplication.class, args);
	}

}
