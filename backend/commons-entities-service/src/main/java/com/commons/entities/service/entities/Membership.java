package com.commons.entities.service.entities;

import java.time.LocalDateTime;

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
	private Short id;
	
	@Column(name = "type_id")
	private Short typeId;
	
	private boolean active;
	
	@Column(name = "start_date")
	private LocalDateTime startDate;
	
	@Column(name = "final_date")
	private LocalDateTime finalDate;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id" , insertable = false , updatable = false)
	private MembershipType type;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
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

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDateTime finalDate) {
		this.finalDate = finalDate;
	}

	public MembershipType getType() {
		return type;
	}

	public void setType(MembershipType type) {
		this.type = type;
	}
	
	
}
