package com.routines.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 *routines microservice entrypoint.
 *EnableEurekaClient annotation enable being 
 *able to be on eureka server.
 */
@EnableEurekaClient
@SpringBootApplication
@EntityScan(basePackages = {"com.routines.restapi.entities", "com.commons.entities.service.entities"})
public class RoutinesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutinesServiceApplication.class, args);
	}

}
