package com.commons.entities.service.entities;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date date;
	
	@Column(name = "start_hour")
	private Time startHour;
	
	@Column(name = "final_hour")
	private Time finalHour;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStartHour() {
		return startHour;
	}

	public void setStartHour(Time startHour) {
		this.startHour = startHour;
	}

	public Time getFinalHour() {
		return finalHour;
	}

	public void setFinalHour(Time finalHour) {
		this.finalHour = finalHour;
	}
	
}
