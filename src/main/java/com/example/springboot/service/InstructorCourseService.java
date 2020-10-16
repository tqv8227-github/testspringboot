package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.InstructorCourse;
import com.example.springboot.repository.InstructorCourseRepoUsingJdbcTemp;
import com.example.springboot.repository.InstructrorCourseRepository;

@Service
public class InstructorCourseService {

	private InstructorCourseRepoUsingJdbcTemp rep;
	
	@Autowired
	private InstructrorCourseRepository rep2;
	
	public InstructorCourseService(InstructorCourseRepoUsingJdbcTemp repository) {
		this.rep = repository;
	}
	
//	public InstructorCourseService(InstructrorCourseRepository repository) {
//		this.rep2 = repository;
//	}
	
	public InstructorCourse getInstructorCourse(int id) {
		return rep.getSingleObj2(id);	
	}
	
	public List<InstructorCourse> getInstructorCourseList(){
		List<InstructorCourse> objList = rep2.findAll();
		return objList;
	}
}
