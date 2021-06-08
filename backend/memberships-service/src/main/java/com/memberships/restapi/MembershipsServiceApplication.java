package com.memberships.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan({"com.commons.entities.service.entities"})
@SpringBootApplication
public class MembershipsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembershipsServiceApplication.class, args);
	}

}
