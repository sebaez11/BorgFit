package com.memberships.restapi.services;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.commons.entities.service.entities.Membership;
import com.commons.entities.service.entities.MembershipType;
import com.memberships.restapi.dto.IMembershipDto;
import com.memberships.restapi.dto.MembershipDto;
import com.memberships.restapi.dto.MembershipTypeDto;
import com.memberships.restapi.models.MembershipResponse;
import com.memberships.restapi.utils.UtilsMethods;

@Service
public class MembershipService {

	@Autowired
	private IMembershipService iMembershipService;
	
	@Autowired
	private IMembershipTypeService iMembershipTypeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UtilsMethods utilsMethods;
	
	public ResponseEntity<MembershipResponse> findByUserId(String id){
		MembershipResponse membershipResponse = new MembershipResponse();
		
		try {
			Collection<IMembershipDto> membership = iMembershipService.findByUserId(id);
			//System.out.print(membership);
			if(membership != null) {
				//MembershipDto membershipDto = new MembershipDto();
				/*Optional<MembershipType> membershipType = iMembershipTypeService.findById(membership.getTypeId());
				membershipDto.setActive(membership.isActive());
				MembershipTypeDto membershipTypeDto = modelMapper.map(membershipType, MembershipTypeDto.class);
				membershipDto.setMembershipType(membershipTypeDto);*/
				MembershipDto membershipDto = new MembershipDto();
				membership.stream().map(IMembershipDto::getName);
				//MembershipDto membershipDto = modelMapper.map(membership, MembershipDto.class);
				//MembershipDto membershipDto = new MembershipDto();
				//membershipDto.setName();
				membershipResponse.setMembership(membershipDto);
				utilsMethods.responseOk(membershipResponse);
			}else {
				utilsMethods.responseMembershipNotFound(membershipResponse);				
			}
		} catch (Exception e) {
			utilsMethods.responseInternalServerError(membershipResponse);
		}
		
		return utilsMethods.response(membershipResponse);
	}
	
}
