package com.example.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Instructor;
import com.example.springboot.service.InstructorService;

@RestController
@RequestMapping("/instructor/")
public class InstructorController {
	InstructorService service;
	
	public InstructorController(InstructorService service) {
		this.service = service;
	}
	
	@GetMapping(value="list", produces="application/json")
	public List<Instructor> getInstructorList(){
		List<Instructor>  instructorList = service.getInstructorList();
		return instructorList;
	}
	
	@GetMapping(value="find/id/{id}", produces="application/json")
	public Instructor findInstructor(@PathVariable(name="id") int id) {
		Instructor instructor = service.getInstructor(id);
		return instructor;
	}
	
	@PostMapping(value="add", consumes="application/json", produces="application/json")
	public Instructor saveInstructor(@RequestBody(required=true) Instructor instructor) {
		service.save(instructor);
		return service.getInstructor(instructor.getId());
	}
	

}
