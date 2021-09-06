package com.memberships.restapi.dto;

public class MembershipDto {
	private boolean active;
	private String name;
	private double cost;
	/* private MembershipTypeDto membershipType; */
	
	public MembershipDto() {}
	
	public void MemberShipDto(boolean active, String name, double cost) {
		this.active = active;
		this.name = name;
		this.cost = cost;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	/*
	 * public MembershipTypeDto getMembershipType() { return membershipType; }
	 * 
	 * public void setMembershipType(MembershipTypeDto membershipType) {
	 * this.membershipType = membershipType; }
	 */

}
