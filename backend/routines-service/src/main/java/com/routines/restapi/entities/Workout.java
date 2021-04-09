package com.routines.restapi.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "workouts")
public class Workout implements Serializable {

	private static final long serialVersionUID = 3752531802265568740L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true , length = 30)
	private String name;
	
	private String photo;
	
	@OneToMany(mappedBy = "workout" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RoutineWorkout> routines;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "workouts_muscle_areas",
			joinColumns = @JoinColumn(name = "workout_id"),
			inverseJoinColumns = @JoinColumn(name = "muscle_areas_id"),
			uniqueConstraints = {
					@UniqueConstraint(
							columnNames = { "workout_id", "muscle_areas_id" }
					) 
			}
	)
	private List<MuscleArea> muscleAreas;
	
	

	public List<RoutineWorkout> getRoutines() {
		return routines;
	}

	public void setRoutines(List<RoutineWorkout> routines) {
		this.routines = routines;
	}

	public List<MuscleArea> getMuscleAreas() {
		return muscleAreas;
	}

	public void setMuscleAreas(List<MuscleArea> muscleAreas) {
		this.muscleAreas = muscleAreas;
	}


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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
