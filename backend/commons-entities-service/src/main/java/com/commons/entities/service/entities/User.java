package com.commons.entities.service.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class describes a user on borgFit platform. It is relationed with
 * itself, role entity, membership entity and reservations entity.
 *
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "identification_number")
	private String identificationNumber;

	@Column(name = "role_id")
	private Short roleId;

	@Column(name = "membership_id", nullable = true)
	private Short membershipId;

	@Column(name = "coach_id", nullable = true)
	private String coachId;

	private String names;

	@Column(name = "last_names")
	private String lastNames;

	@Column(unique = true)
	private String email;

	private String password;
	private String address;

	@Column(name = "phone_number")
	private String phoneNumber;

	private String photo;
	private boolean active;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	@JsonIgnoreProperties(value = { "user", "hibernateLazyInitializer" })
	private Role role;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "membership_id", insertable = false, updatable = false)
	private Membership membership;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "coach_id", insertable = false, updatable = false)
	@JsonIgnoreProperties(value = { "user", "hibernateLazyInitializer" })
	private User coach;
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinTable(
	name = "users_reservations",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "reservation_id"),
	uniqueConstraints = {
			@UniqueConstraint(
					columnNames = { "user_id", "reservation_id" }
			) 
	}
	)
	private List<Reservation> reservations;

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public Short getRoleId() {
		return roleId;
	}

	public void setRoleId(Short roleId) {
		this.roleId = roleId;
	}

	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getCoach() {
		return coach;
	}

	public void setCoach(User coach) {
		this.coach = coach;
	}

	public Short getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Short membershipId) {
		this.membershipId = membershipId;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

}
