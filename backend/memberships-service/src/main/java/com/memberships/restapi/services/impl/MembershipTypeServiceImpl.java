package com.memberships.restapi.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.entities.service.entities.MembershipType;
import com.memberships.restapi.repositories.MembershipTypeRepository;
import com.memberships.restapi.services.IMembershipTypeService;


@Service
public class MembershipTypeServiceImpl implements IMembershipTypeService {
	
	@Autowired
	private MembershipTypeRepository membershipTypeRepo;

	@Override
	public Optional<MembershipType> findById(Integer id) {
		return membershipTypeRepo.findById(id);
	}


}
