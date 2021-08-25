package com.memberships.restapi;

import org.springframework.data.repository.CrudRepository;

import com.commons.entities.service.entities.Membership;

public interface MembershipRepo extends CrudRepository<Membership, Integer> {

	public Membership findByUsers_identificationNumber(String id);
	
}
