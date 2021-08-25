package com.payments.restapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.restapi.repositories.PaymentRepository;
import com.payments.restapi.services.IPaymentService;


@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
}
