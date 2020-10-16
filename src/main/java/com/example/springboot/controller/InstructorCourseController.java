package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.InstructorCourse;
import com.example.springboot.service.InstructorCourseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/instructor-course/")
public class InstructorCourseController {
	
	@Autowired
	private InstructorCourseService service;
	
	@GetMapping(value="id/{id}", produces="application/json")
	public ResponseEntity<InstructorCourse> getObj(@PathVariable(name="id") int id){
		
		InstructorCourse obj = service.getInstructorCourse(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("header1", "test value 1");
		headers.add("header2", "test value 2");
		
		return ResponseEntity.accepted().headers(headers).body(obj);
	}
	
	@GetMapping(value="all", produces="application/json")
	public ResponseEntity<List<InstructorCourse>> getAll(){
		List<InstructorCourse> objList=service.getInstructorCourseList(); 
		HttpStatus status = HttpStatus.ACCEPTED;
		return ResponseEntity.status(status).body(objList);
	}

	
}
