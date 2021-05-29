package com.routines.restapi.models;

import com.commons.entities.service.entities.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RoutineResponse {

	private Status status;

	public RoutineResponse() {
		this.status = new Status();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
