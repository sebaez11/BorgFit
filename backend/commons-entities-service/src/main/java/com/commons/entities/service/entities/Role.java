package com.commons.entities.service.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Role entity describes a user role on platform.
 * It can be "ROLE_CUSTOMER", "ROLE_COACH",
 * "ROLE_ADMIN" o "ROLE_ADMINISTRATIVE".
 *
 */
@Entity
@Table(name = "roles")
public class Role {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	private String name;
	
	
	public Short getId() {
		return id;
	}
	public void setId(Short id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
