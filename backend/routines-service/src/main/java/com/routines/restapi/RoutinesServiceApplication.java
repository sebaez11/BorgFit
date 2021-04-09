package com.routines.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RoutinesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutinesServiceApplication.class, args);
	}

}
