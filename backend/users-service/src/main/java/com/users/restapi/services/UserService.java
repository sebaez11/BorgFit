package com.users.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.commons.entities.service.entities.User;
import com.users.restapi.models.UserResponse;
import com.users.restapi.utils.UtilsMethods;


/**
 *Represents a zone where is going to apply the microservice logic.
 */
@Service
public class UserService {

	@Autowired
	private UtilsMethods utilsMethods;
	
	@Autowired
	private IUserService iUserService;
	
	
	/**
	 * 
	 * @param user - refers the object to be saved on database.
	 * @return a response according to what happens.
	 */
	public ResponseEntity<UserResponse> save(User user){
		
		UserResponse userResponse = new UserResponse();
		
		if(iUserService.findByEmail(user.getEmail()) == null && iUserService.findById(user.getIdentificationNumber()) == null) {
			try {
				iUserService.save(user);
				utilsMethods.responseOk(userResponse);
			} catch (Exception e) {
				utilsMethods.responseInternalServerError(userResponse);
			}
			
		} else {
			utilsMethods.responseBadRequest(userResponse);
		}
		
		return utilsMethods.response(userResponse);
		
	}
	
}
