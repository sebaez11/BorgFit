package com.routines.restapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *Workout entity.
 */
@Entity
@Table(name = "workouts")
public class Workout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Short series;
	private Short repetitions;
	private String photo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Short getSeries() {
		return series;
	}
	public void setSeries(Short series) {
		this.series = series;
	}
	public Short getRepetitions() {
		return repetitions;
	}
	public void setRepetitions(Short repetitions) {
		this.repetitions = repetitions;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
