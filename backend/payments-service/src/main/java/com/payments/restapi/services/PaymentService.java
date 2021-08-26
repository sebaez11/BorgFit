package com.payments.restapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.payments.restapi.clients.UserFeignClient;
import com.payments.restapi.dto.PaymentDto;
import com.payments.restapi.entities.Payment;
import com.payments.restapi.models.PaymentResponse;
import com.payments.restapi.utils.UtilMethods;

@Service
public class PaymentService {

	@Autowired
	private IPaymentService iPaymentService;
	
	@Autowired
	private UtilMethods utilMethods;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserFeignClient userClient;
	
	public ResponseEntity<PaymentResponse> findAllByUserId(String userId){
		boolean userExists = userClient.existsById(userId);
		PaymentResponse paymentResponse = new PaymentResponse();
		
		if(userExists) {		
			try {
				
				List<Payment> payments = iPaymentService.findAllByUserId(userId);
				List<PaymentDto> paymentsDto = payments.stream()
						.map(payment -> modelMapper.map(payment, PaymentDto.class))
						.collect(Collectors.toList());
				
				paymentResponse.setPayments(paymentsDto);
				utilMethods.responseOk(paymentResponse);
				
			} catch (Exception e) {
				utilMethods.responseInternalServerError(paymentResponse);
			}
			
		}else {
			utilMethods.responseBadRequest(paymentResponse);
		}
		
		
		return utilMethods.response(paymentResponse);
	}
	
}
