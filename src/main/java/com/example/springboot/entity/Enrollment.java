package com.example.springboot.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.example.springboot.entity.*;

import lombok.Data;

@Entity
@Data
//@Component
@Table(name="enrollments")
public class Enrollment {

	public Enrollment() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="studentid")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="courseid")
	private Course course;
	
	@Column(name="enrolldate")
	private LocalDate enrollDate;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="comment")
	private String comment;

//	public int getId() {
//		return id;
//	}
//
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}

//	public Course getCourse() {
//		return course;
//	}
//
//	public void setCourse(Course course) {
//		this.course = course;
//	}

//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public LocalDate getEnrollDate() {
//		return enrollDate;
//	}
//
//	public void setEnrollDate(LocalDate enrollDate) {
//		this.enrollDate = enrollDate;
//	}
//
//	public String getGrade() {
//		return grade;
//	}
//
//	public void setGrade(String grade) {
//		this.grade = grade;
//	}
//
//	public String getComment() {
//		return comment;
//	}
//
//	public void setComment(String comment) {
//		this.comment = comment;
//	}
	
	
}
