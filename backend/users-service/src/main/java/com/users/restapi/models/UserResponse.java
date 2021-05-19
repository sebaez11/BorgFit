package com.users.restapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Represents an centralized container that will contain
 * all response types, with a status object.
 */
@JsonInclude(Include.NON_NULL)
public class UserResponse {

	private Status status;

	public UserResponse() {
		this.status = new Status();
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
