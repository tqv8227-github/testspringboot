package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.Enrollment;
import com.example.springboot.entity.InstructorCourse;
import com.example.springboot.entity.Student;

@Configuration
public class BeanDefinitionConfig {

	public BeanDefinitionConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean(name="studentObj")
	public Student getStudent() {
		Student student = new Student();
		return student;
	}
	
	@Bean(name="courseObj")
	public Course getCourse() {
		return new Course();
	}
	
	@Bean(name="enrollmentObj")
	public Enrollment getEnrollment() {
		return new Enrollment();
	}
	
	@Bean
	public InstructorCourse getInstructorCourse() {
		return new InstructorCourse();
	}

}
