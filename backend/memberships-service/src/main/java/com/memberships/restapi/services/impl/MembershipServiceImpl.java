package com.memberships.restapi.services.impl;

import java.util.Collection;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.entities.service.entities.Membership;
import com.memberships.restapi.dto.IMembershipDto;
import com.memberships.restapi.dto.MembershipDto;
import com.memberships.restapi.repositories.MembershipRepository;
import com.memberships.restapi.services.IMembershipService;

@Service
public class MembershipServiceImpl implements IMembershipService {

	@Autowired
	private MembershipRepository membershipRepository;
	
	@Override
	public Collection<IMembershipDto> findByUserId(String id) {
		return membershipRepository.findByUserId(id);
	}

}
