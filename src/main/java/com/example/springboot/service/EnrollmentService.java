package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Enrollment;
import com.example.springboot.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

	@Autowired
	EnrollmentRepository rep;
	
	@Autowired
	@Qualifier("enrollmentObj")
	private Enrollment enrollment;
	
	public EnrollmentService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Enrollment> getEnrollmentList(){
		List<Enrollment> enrollmentList = rep.findAll();
		return enrollmentList;
	}
	
	public Enrollment findById(int id) {
		Enrollment enrollment = rep.findById(id).get();
		return enrollment;
	}

}
