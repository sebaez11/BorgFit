package com.commons.entities.service.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "memberships")
public class Membership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "type_id" , nullable = false)
	private Short typeId;
	
	private boolean active;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "final_date")
	private LocalDate finalDate;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id" , insertable = false , updatable = false)
	private MembershipType type;

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
	
}
