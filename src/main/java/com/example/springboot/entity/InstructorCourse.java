package com.example.springboot.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.datetime.joda.DateTimeParser;
import lombok.Data;


@Entity
@Data
@Table(name="instructor_courses")
public class InstructorCourse {
	@Id
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="instructorid")
	private Instructor instructor;
	
	@ManyToOne
	@JoinColumn(name="courseid")
	private Course course;
	
	@Column(name="starttime")
	private LocalTime startTime;
	
	@Column(name="endtime")
	private LocalTime endTime;
	
}
