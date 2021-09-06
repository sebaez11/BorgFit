package com.users.restapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.commons.entities.service.entities.Role;
import com.commons.entities.service.entities.User;
import com.users.restapi.clients.AuthFeignClient;
import com.users.restapi.dto.UserDto;
import com.users.restapi.dto.UserJwtDto;
import com.users.restapi.dto.UserLoginDto;
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
	
	@Autowired
	private AuthFeignClient authClient;
	
	
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
				user.setPassword(utilsMethods.hashPassword(user.getPassword()));
				iUserService.save(user);
				utilsMethods.responseOk(userResponse);
			} catch (Exception e) {
				utilsMethods.responseInternalServerError(userResponse);
			}
			
		} else {
			utilsMethods.responseUnprocessableEntity(userResponse);
		}
		System.out.print(userResponse);
		return utilsMethods.response(userResponse);
		
	}
	
	
	
	
	
	public ResponseEntity<UserResponse> login(UserLoginDto userDto, String roleName){
		UserResponse userResponse = new UserResponse();
		try {
			String identificationNumber = userDto.getIdentificationNumber();
			String password = userDto.getPassword();
			User user = iUserService.findByIdentificationNumber(identificationNumber);
			if(user == null) {
				utilsMethods.responseUserNotFound(userResponse);
			}
			boolean passwordMatched = utilsMethods.checkPassword(password, user.getPassword());
			if(passwordMatched) {
				try {
					Integer roleId = user.getRoleId();
					Role role = iRoleService.findById(roleId);
					String roleNameUserDb = role.getName();
					System.out.print(role.getName());
					System.out.print(roleName);
					if(roleNameUserDb.equals(roleName)) {
						String token = authClient.getJwtToken(userDto);
						UserJwtDto userJwtDto = new UserJwtDto();
						userJwtDto.setIdentificationNumber(identificationNumber);
						userJwtDto.setToken(token);
						userResponse.setUserJwt(userJwtDto);
						utilsMethods.responseOk(userResponse);
					}else {
						utilsMethods.responseUnauthorizedUser(userResponse);
					}
				} catch (Exception e) {
					utilsMethods.responseInternalServerError(userResponse);
				}
			}else {
				utilsMethods.responseUserNotFound(userResponse);
			}
		} catch (Exception e) {
			utilsMethods.responseInternalServerError(userResponse);
		}
		System.out.print(userResponse);
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
