package com.payments.restapi.dto;

public class CreatePaymentDto {

	private double amount;
	private String userId;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
