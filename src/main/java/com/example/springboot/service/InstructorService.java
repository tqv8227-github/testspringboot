package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Instructor;
import com.example.springboot.repository.InstructorRepository;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

	@Autowired
	Instructor instructor;
	
	// @Autowired dependency injection by class member
	InstructorRepository rep;
	
	public InstructorService(InstructorRepository repository) {   // dependency injection by constructor
		this.rep = repository;
	}
	
	public List<Instructor> getInstructorList(){
		return rep.findAll();
	}
	
	public Instructor getInstructor(int id) {
		Optional<Instructor> opt = rep.findById(id);
		return (Instructor) opt.get();
	}
	
	public String deleteInstructor(int id) {
		if (rep.existsById(id)) {
			Instructor instructor = (Instructor) rep.findById(id).get();
			rep.delete(instructor);
			return "Successful";
		}
		return "Instructor with id "+id+" is not found";
	}
	
	public void deleteInstructor(Instructor instructor) {
		rep.delete(instructor);
	}
	
	public void save(Instructor instructor) {
		rep.save(instructor);
	}
}
