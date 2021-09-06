package com.users.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * It is the entrypoint for users microservice.
 * The annotation "EntityScan" invoke a project that works
 * like commons entity on microservices.
 *
 */
@EntityScan({"com.commons.entities.service.entities"})
@EnableFeignClients
@SpringBootApplication
public class UsersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersServiceApplication.class, args);
	}

}
