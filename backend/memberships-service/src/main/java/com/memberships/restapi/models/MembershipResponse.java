package com.memberships.restapi.models;

import com.commons.entities.service.entities.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.memberships.restapi.dto.MembershipDto;

/**
 * Represents an centralized container that will contain all response types,
 * with a status object.
 */
@JsonInclude(Include.NON_NULL)
public class MembershipResponse {

	private Status status;
	private MembershipDto membership;

	public MembershipResponse() {
		this.status = new Status();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public MembershipDto getMembership() {
		return membership;
	}

	public void setMembership(MembershipDto membership) {
		this.membership = membership;
	}

}
