package com.memberships.restapi.services;

import java.util.Optional;

import com.commons.entities.service.entities.MembershipType;

public interface IMembershipTypeService {

	public Optional<MembershipType> findById(Integer id);
		
}
