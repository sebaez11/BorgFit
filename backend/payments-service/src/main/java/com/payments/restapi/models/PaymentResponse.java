package com.payments.restapi.models;

import java.util.List;

import com.commons.entities.service.entities.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.payments.restapi.dto.PaymentDto;

@JsonInclude(Include.NON_NULL)
public class PaymentResponse {
	
	private Status status;
	private List<PaymentDto> payments;
	
	public PaymentResponse() {
		this.status = new Status();
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<PaymentDto> getPayments() {
		return payments;
	}
	public void setPayments(List<PaymentDto> payments) {
		this.payments = payments;
	}
	
}
