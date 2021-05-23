package com.users.restapi.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.users.restapi.dto.UserDto;

/**
 * Represents an centralized container that will contain all response types,
 * with a status object.
 */
@JsonInclude(Include.NON_NULL)
public class UserResponse {

	private Status status;
	private UserDto user;
	private List<UserDto> users;

	public UserResponse() {
		this.status = new Status();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	

}
