package com.payments.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = {com.payments.service.entities.Payment.class,com.commons.entities.service.entities.User.class})
public class PaymentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsServiceApplication.class, args);
	}

}
