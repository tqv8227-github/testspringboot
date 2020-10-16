package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="instructors")
public class Instructor {

	@Column(name="id")
	@Id
	private int id;
	
	@Column (name="firstname")
	private String firstName;
	
	@Column (name="lastname")
	private String lastName;
	
	@Column (name="mi")
	private String mInitial;
	
	@Column (name="isactive")
	private String isActive;

//	public String getmInitial() {
//		return mInitial;
//	}
//
//	public void setmInitial(String mInitial) {
//		this.mInitial = mInitial;
//	}
//	
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	public String getfirstName() {
//		return firstName;
//	}
//
//	public void setfirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	
//	public String getlastName() {
//		return lastName;
//	}
//
//	public void setlastName(String lastName) {
//		this.lastName = lastName;
//	}
//	
//	public String getisActive() {
//		return isActive;
//	}
//
//	public void setisActive(String isActive) {
//		this.isActive = isActive;
//	}
	
	
	
}
