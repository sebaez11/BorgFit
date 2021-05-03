package com.memberships.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan({"com.commons.memberships.service.entities"})
@SpringBootApplication
public class MembershipsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembershipsServiceApplication.class, args);
	}

}
