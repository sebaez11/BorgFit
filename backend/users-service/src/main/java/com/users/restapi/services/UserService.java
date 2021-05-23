package com.users.restapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.commons.entities.service.entities.User;
import com.users.restapi.dto.UserDto;
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
	
	@Autowired
	private IRoleService iRoleService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	/**
	 * 
	 * @param user - refers the object to be saved on database.
	 * @return a response according to what happens.
	 */
	public ResponseEntity<UserResponse> save(User user , String role){
		
		UserResponse userResponse = new UserResponse();
		
		if(iUserService.findByEmail(user.getEmail()) == null && iUserService.findById(user.getIdentificationNumber()) == null) {
			
			
			if(role == "ROLE_CUSTOMER" || role == "ROLE_COACH" || role == "ROLE_ADMINISTRATIVE") {
				Short roleId = iRoleService.findByName(role).getId();
				user.setRoleId(roleId);				
			}else {
				utilsMethods.responseInternalServerError(userResponse);
			}
			
			try {
				user.setActive(true);
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
	
	public ResponseEntity<UserResponse> findAll(){
		UserResponse userResponse = new UserResponse();
		
		try {
			List<User> users = iUserService.findAll();
			List<UserDto> usersDto = users.stream()
					.map(user -> modelMapper.map(user, UserDto.class))
					.collect(Collectors.toList());
			
			userResponse.setUsers(usersDto);
			utilsMethods.responseOk(userResponse);
		} catch (Exception e) {
			utilsMethods.responseInternalServerError(userResponse);
		}
		
		return utilsMethods.response(userResponse);
		
	}
	
	public ResponseEntity<UserResponse> findAllByRoleName(String role){
		UserResponse userResponse = new UserResponse();
		System.out.print(role);
		if(role == "ROLE_CUSTOMER" || role == "ROLE_COACH" || role == "ROLE_ADMINISTRATIVE") {
			try {
				List<User> users = iUserService.findAllByRoleName(role);
				List<UserDto> usersDto = users.stream()
											.map(user -> modelMapper.map(user, UserDto.class))
											.collect(Collectors.toList());
				
				userResponse.setUsers(usersDto);
				utilsMethods.responseOk(userResponse);
				
			} catch (Exception e) {
				utilsMethods.responseInternalServerError(userResponse);
			}
		}else {
			utilsMethods.responseBadRequest(userResponse);
		}
		
		return utilsMethods.response(userResponse);
	}
	
	public ResponseEntity<UserResponse> findById(String id){
		UserResponse userResponse = new UserResponse();
		
		if(id != null) {
			try {
				User user = iUserService.findById(id);
				UserDto userDto = modelMapper.map(user, UserDto.class);
				userResponse.setUser(userDto);
				utilsMethods.responseOk(userResponse);
				
			} catch (Exception e) {
				utilsMethods.responseInternalServerError(userResponse);
			}
		}else {
			utilsMethods.responseBadRequest(userResponse);
		}
		
		return utilsMethods.response(userResponse);
	}
	
}
