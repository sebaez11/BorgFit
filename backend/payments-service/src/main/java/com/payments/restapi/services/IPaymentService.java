package com.payments.restapi.services;

import java.util.List;

import com.payments.restapi.entities.Payment;

public interface IPaymentService {

	public List<Payment> findAllByUserId(String userId);
	
}
