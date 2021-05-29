package com.routines.restapi.entities;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.commons.entities.service.entities.User;



/**
 * routine entity. it has a relationship with 
 * RoutinesGroup entity and Workout entity.
 */
@Entity
@Table(name = "routines")
public class Routine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private Short level;
	
	@Column(name = "routine_group_id")
	private Short routinesGroupId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "routine_group_id" , insertable = false , updatable = false)
	private RoutinesGroup routinesGroup;
	

	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinTable(
	name = "routines_workouts",
	joinColumns = @JoinColumn(name = "routine_id"),
	inverseJoinColumns = @JoinColumn(name = "workout_id"),
	uniqueConstraints = {
			@UniqueConstraint(
					columnNames = { "routine_id", "workout_id" }
			) 
	}
	)
	private List<Workout> workouts;
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinTable(
	name = "routines_users",
	joinColumns = @JoinColumn(name = "routine_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> users;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Short getLevel() {
		return level;
	}


	public void setLevel(Short level) {
		this.level = level;
	}


	public List<Workout> getWorkouts() {
		return workouts;
	}


	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}


	public Short getRoutinesGroupId() {
		return routinesGroupId;
	}


	public void setRoutinesGroupId(Short routinesGroupId) {
		this.routinesGroupId = routinesGroupId;
	}


	public RoutinesGroup getRoutinesGroup() {
		return routinesGroup;
	}


	public void setRoutinesGroup(RoutinesGroup routinesGroup) {
		this.routinesGroup = routinesGroup;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
