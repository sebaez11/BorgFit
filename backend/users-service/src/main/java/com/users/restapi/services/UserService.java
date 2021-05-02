package com.users.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.commons.users.service.entities.User;
import com.users.restapi.models.UserResponse;
import com.users.restapi.utils.UtilsMethods;

@Service
public class UserService {

	@Autowired
	private UtilsMethods utilsMethods;
	
	@Autowired
	private IUserService iUserService;
	
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
