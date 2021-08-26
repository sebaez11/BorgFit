package com.payments.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.payments.restapi.models.PaymentResponse;
import com.payments.restapi.services.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/users/{userId}/payments/")
	public ResponseEntity<PaymentResponse> findAllByUserId(@PathVariable String userId){
		return paymentService.findAllByUserId(userId);
	}
	
	
}
