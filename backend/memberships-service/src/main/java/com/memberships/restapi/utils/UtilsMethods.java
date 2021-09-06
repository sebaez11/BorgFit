package com.memberships.restapi.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.memberships.restapi.models.MembershipResponse;


/**
 *Represents a centralized container that contains 
 *all possible responses on users microservice.
 */
@Configuration
public class UtilsMethods {

	
	/**
	 * 
	 * @param userResponse - a generic user response on users microservice.
	 * @return an object userResponse with a transaction status.
	 */
	public ResponseEntity<MembershipResponse> response(MembershipResponse userResponse){
		return new ResponseEntity<>(userResponse , HttpStatus.valueOf(userResponse.getStatus().getStatusCode()));
	}
	
	
	/**
	 * 
	 * @param userResponse - a generic user response on users microservice.
	 * This kind of methods fill the user response up of metadata.
	 */
	public void responseOk(MembershipResponse membershipResponse) {
		membershipResponse.getStatus().setStatusCode(HttpStatus.CREATED.value());
		membershipResponse.getStatus().setStatusDescription(Constants.SUCCESS_MESSAGE);
		membershipResponse.getStatus().setSeverity(Constants.SEVERITY_INFO);
	}
	
	public void responseUpdated(MembershipResponse membershipResponse) {
		membershipResponse.getStatus().setStatusCode(HttpStatus.OK.value());
		membershipResponse.getStatus().setStatusDescription(Constants.UPDATED_MESSAGE);
		membershipResponse.getStatus().setSeverity(Constants.SEVERITY_INFO);
	}
	
	public void responseBadRequest(MembershipResponse membershipResponse) {

		membershipResponse.getStatus().setStatusCode(HttpStatus.BAD_REQUEST.value());
		membershipResponse.getStatus().setStatusDescription(Constants.BAD_REQUEST_MESSAGE);
		membershipResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);

	}
	
	public void responseUnprocessableEntity(MembershipResponse membershipResponse) {
		
		membershipResponse.getStatus().setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		membershipResponse.getStatus().setStatusDescription(Constants.NO_UNIQUE_INFORMATION_MESSAGE);
		membershipResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);
		
	}
	
	public void responseInternalServerError(MembershipResponse membershipResponse) {
		
		membershipResponse.getStatus().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		membershipResponse.getStatus().setStatusDescription(Constants.INTERNAL_SERVER_ERROR_MESSAGE);
		membershipResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);
		
	}
	
	public void responseMembershipNotFound(MembershipResponse membershipResponse) {

		membershipResponse.getStatus().setStatusCode(HttpStatus.NOT_FOUND.value());
		membershipResponse.getStatus().setStatusDescription(Constants.USER_NOT_FOUND_MESSAGE);
		membershipResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);

	}
	
	public void responseUnauthorizedUser(MembershipResponse membershipResponse) {

		membershipResponse.getStatus().setStatusCode(HttpStatus.UNAUTHORIZED.value());
		membershipResponse.getStatus().setStatusDescription(Constants.UNAUTHORIZED_USER);
		membershipResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);

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
