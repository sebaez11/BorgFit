package com.commons.reservations.service.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users_reservations")
public class UserReservation {

	private boolean active;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
