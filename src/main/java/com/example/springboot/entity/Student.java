package com.example.springboot.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import com.example.springboot.entity.Enrollment;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Entity   // represent a model class and should be transform to a table in database
@Data    // create setters and getters
@Table(name = "students")   // map this entity to real table in database
//@NoArgsConstructor
@AllArgsConstructor
//@Component    // need to have this in order to use Autowired annotation (auto-detected and registered by spring boot)
@Slf4j

public class Student implements Cloneable{

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="sex")
	private char sex;
	
	@Column (name="dob", columnDefinition="DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
//	@OneToMany(mappedBy="students")
//	List<Enrollment> enrollments;
	
	@PostConstruct
	public void postConstruct() {
		log.info("PostConstruct is called");
		System.out.println("PostConstruct is called");
	}
	
	@PreDestroy
	public void destroy() {
		log.info("predestroy is called");
		//System.out.println("predestroy is called");
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
		log.info("Student constructor is called");
		//System.out.println("Student constructor is called");
	}

	public Object clone() throws CloneNotSupportedException {   // make student class cloneable
		return super.clone();
	}
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public char getSex() {
//		return sex;
//	}
//
//	public void setSex(char sex) {
//		this.sex = sex;
//	}
//
//	public LocalDate getDob() {
//		return dob;
//	}
//
//	public void setDob(LocalDate dob) {
//		this.dob = dob;
//	}

//	public Set<Enrollment> getEnrollments() {
//		return enrollments;
//	}
//
//	public void setEnrollments(Set<Enrollment> enrollments) {
//		this.enrollments = enrollments;
//	}
	
	
}
