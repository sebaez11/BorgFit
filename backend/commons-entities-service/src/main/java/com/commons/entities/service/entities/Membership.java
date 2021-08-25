package com.commons.entities.service.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "memberships")
public class Membership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "type_id", nullable = false)
	private Short typeId;

	private boolean active;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "final_date")
	private LocalDate finalDate;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id", insertable = false, updatable = false)
	@JsonIgnoreProperties(value = { "membership", "hibernateLazyInitializer" })
	private MembershipType type;

	@OneToMany(mappedBy = "membership")
	@JsonIgnore
	private List<User> users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getTypeId() {
		return typeId;
	}

	public void setTypeId(Short typeId) {
		this.typeId = typeId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}

	public MembershipType getType() {
		return type;
	}

	public void setType(MembershipType type) {
		this.type = type;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
