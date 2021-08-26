package com.payments.restapi.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.payments.restapi.models.PaymentResponse;


@Configuration
public class UtilMethods {

	public ResponseEntity<PaymentResponse> response(PaymentResponse paymentResponse){
		return new ResponseEntity<>(paymentResponse , HttpStatus.valueOf(paymentResponse.getStatus().getStatusCode()));
	}
	
	public void responseOk(PaymentResponse paymentResponse) {
		paymentResponse.getStatus().setStatusCode(HttpStatus.CREATED.value());
		paymentResponse.getStatus().setStatusDescription(Constants.SUCCESS_MESSAGE);
		paymentResponse.getStatus().setSeverity(Constants.SEVERITY_INFO);
	}
	
	public void responseBadRequest(PaymentResponse paymentResponse) {

		paymentResponse.getStatus().setStatusCode(HttpStatus.BAD_REQUEST.value());
		paymentResponse.getStatus().setStatusDescription(Constants.BAD_REQUEST_MESSAGE);
		paymentResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);

	}
	
	public void responseInternalServerError(PaymentResponse paymentResponse) {
		
		paymentResponse.getStatus().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		paymentResponse.getStatus().setStatusDescription(Constants.INTERNAL_SERVER_ERROR_MESSAGE);
		paymentResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);
		
	}
	
}
