package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.Enrollment;
import com.example.springboot.entity.Instructor;
import com.example.springboot.entity.Student;

@Configuration
public class BeanDefinitionConfigExt {

	public BeanDefinitionConfigExt() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean(name="studentObj2")
	public Student getStudent2() {
		Student student = new Student();
		return student;
	}
	
	@Bean(name="courseObj2")
	public Course getCourse2() {
		return new Course();
	}
	
	@Bean(name="enrollmentObj2")
	public Enrollment getEnrollment2() {
		return new Enrollment();
	}
	
	@Bean
	public Instructor instructor() {
		return new Instructor();
	}

}
