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
		
		boolean userExistsById = iUserService.existsById(user.getIdentificationNumber());
		boolean userExistsByEmail = iUserService.existsByEmail(user.getEmail());
		
		if(!userExistsById && !userExistsByEmail) {
			
			
			if(role == "ROLE_CUSTOMER" || role == "ROLE_COACH" || role == "ROLE_ADMINISTRATIVE") {
				Integer roleId = iRoleService.findByName(role).getId();
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
	
	public ResponseEntity<UserResponse> findAllByRoleName(String role){
		UserResponse userResponse = new UserResponse();
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
			boolean userExists = iUserService.existsByIdAndActiveTrue(id);
			if(userExists) {
				try {
					User user = iUserService.findById(id);
					UserDto userDto = modelMapper.map(user, UserDto.class);
					userResponse.setUser(userDto);
					utilsMethods.responseOk(userResponse);
					
				} catch (Exception e) {
					utilsMethods.responseInternalServerError(userResponse);
				}				
			}else {
				utilsMethods.responseUserNotFound(userResponse);
			}
		}else {
			utilsMethods.responseBadRequest(userResponse);
		}
		
		return utilsMethods.response(userResponse);
	}
	
	public ResponseEntity<UserResponse> update(User newUser , String id){
		UserResponse userResponse = new UserResponse();
		
		boolean userExists = iUserService.existsByIdAndActiveTrue(id);
		
		if(userExists) {
			
			try {
				
				User user = iUserService.findById(id);
				//user.setIdentificationNumber(newUser.getIdentificationNumber());
				user.setNames(newUser.getNames());
				user.setLastNames(newUser.getLastNames());
				user.setEmail(newUser.getEmail());
				user.setAddress(newUser.getAddress());
				user.setPhoneNumber(newUser.getPhoneNumber());
				user.setPhoto(newUser.getPhoto());
				
				iUserService.save(user);
				utilsMethods.responseUpdated(userResponse);
				
			} catch (Exception e) {
				System.out.print(e);
				utilsMethods.responseInternalServerError(userResponse);
			}
			
			
			
		}else {
			utilsMethods.responseUserNotFound(userResponse);
		}
		
		return utilsMethods.response(userResponse);
	}
	
	public ResponseEntity<UserResponse> deactivate(String id){
		UserResponse userResponse = new UserResponse();
		
		boolean userExists = iUserService.existsByIdAndActiveTrue(id);
		
		if(userExists) {
			
			try {
				User user = iUserService.findById(id);
				user.setActive(false);
				iUserService.save(user);
				
				utilsMethods.responseOk(userResponse);
				
			} catch (Exception e) {
				utilsMethods.responseInternalServerError(userResponse);
			}
			
		}else {
			utilsMethods.responseUserNotFound(userResponse);
		}
		
		return utilsMethods.response(userResponse);
	}
	
}
