package com.routines.restapi.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "routines")
public class Routine implements Serializable {

	private static final long serialVersionUID = -909961319337549616L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String photo;
	private String description;

	
	@OneToMany(mappedBy = "routine" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RoutineWorkout> workouts;
	
	
	public List<RoutineWorkout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<RoutineWorkout> workouts) {
		this.workouts = workouts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
