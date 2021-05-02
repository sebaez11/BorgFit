package com.users.restapi.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.users.restapi.models.UserResponse;

@Configuration
public class UtilsMethods {

	public ResponseEntity<UserResponse> response(UserResponse userResponse){
		return new ResponseEntity<>(userResponse , HttpStatus.valueOf(userResponse.getStatus().getStatusCode()));
	}
	
	public void responseOk(UserResponse userResponse) {
		userResponse.getStatus().setStatusCode(HttpStatus.CREATED.value());
		userResponse.getStatus().setStatusDescription(Constants.SUCCESS_MESSAGE);
		userResponse.getStatus().setSeverity(Constants.SEVERITY_INFO);
	}
	
	public void responseBadRequest(UserResponse userResponse) {

		userResponse.getStatus().setStatusCode(HttpStatus.BAD_REQUEST.value());
		userResponse.getStatus().setStatusDescription(Constants.BAD_REQUEST_MESSAGE);
		userResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);

	}
	
	public void responseInternalServerError(UserResponse userResponse) {
		
		userResponse.getStatus().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		userResponse.getStatus().setStatusDescription(Constants.INTERNAL_SERVER_ERROR_MESSAGE);
		userResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);
		
	}
	
	public void responseUserNotFound(UserResponse userResponse) {

		userResponse.getStatus().setStatusCode(HttpStatus.BAD_REQUEST.value());
		userResponse.getStatus().setStatusDescription(Constants.USER_NOT_FOUND_MESSAGE);
		userResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);

	}
	
	public String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	public Boolean checkPassword(String plainTextPassword , String hashedPassword) {
		if(BCrypt.checkpw(plainTextPassword, hashedPassword)) {
			return true;
		} else {
			return false;
		}
	}
	
	
}