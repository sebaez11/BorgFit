package com.routines.restapi.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.routines.restapi.models.RoutineResponse;

/**
 * Represents a centralized container that contains all possible responses on
 * routines microservice.
 */
@Configuration
public class UtilsMethods {

	/**
	 * 
	 * @param routineResponse - a generic routine response on routines microservice.
	 * @return an object routineResponse with a transaction status.
	 */
	public ResponseEntity<RoutineResponse> response(RoutineResponse routineResponse) {
		return new ResponseEntity<>(routineResponse, HttpStatus.valueOf(routineResponse.getStatus().getStatusCode()));
	}

	public void responseOk(RoutineResponse routineResponse) {
		routineResponse.getStatus().setStatusCode(HttpStatus.OK.value());
		routineResponse.getStatus().setStatusDescription(Constants.SUCCESS_MESSAGE);
		routineResponse.getStatus().setSeverity(Constants.SEVERITY_INFO);
	}

	public void responseUpdated(RoutineResponse routineResponse) {
		routineResponse.getStatus().setStatusCode(HttpStatus.OK.value());
		routineResponse.getStatus().setStatusDescription(Constants.UPDATED_MESSAGE);
		routineResponse.getStatus().setSeverity(Constants.SEVERITY_INFO);
	}

	public void responseBadRequest(RoutineResponse routineResponse) {

		routineResponse.getStatus().setStatusCode(HttpStatus.BAD_REQUEST.value());
		routineResponse.getStatus().setStatusDescription(Constants.BAD_REQUEST_MESSAGE);
		routineResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);

	}

	public void responseInternalServerError(RoutineResponse routineResponse) {

		routineResponse.getStatus().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		routineResponse.getStatus().setStatusDescription(Constants.INTERNAL_SERVER_ERROR_MESSAGE);
		routineResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);

	}

}
