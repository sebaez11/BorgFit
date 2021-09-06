package com.memberships.restapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.commons.entities.service.entities.MembershipType;

public interface MembershipTypeRepository extends CrudRepository<MembershipType, Integer> {

	
}
