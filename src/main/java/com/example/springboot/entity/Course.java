package com.example.springboot.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
//@Component
@Table(name="courses")
public class Course {
	@Id
	@Column (name="id")
	private int id;
	
	@Column(name="units")
	private int units;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "courses")
//	private List<Enrollment> enrollment;
//
//	public List<Enrollment> getEnrollment() {
//		return enrollment;
//	}
//
//	public void setEnrollment(List<Enrollment> enrollment) {
//		this.enrollment = enrollment;
//	}

	public Course() {
		// TODO Auto-generated constructor stub
	}

//	public int getId() {
//		return id;
//	}
//	
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getUnits() {
//		return units;
//	}
//
//	public void setUnits(int units) {
//		this.units = units;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	
	

}
