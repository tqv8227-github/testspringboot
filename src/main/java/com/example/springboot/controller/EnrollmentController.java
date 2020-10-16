package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Enrollment;
import com.example.springboot.service.EnrollmentService;

@RestController     // this is equivalent to @Controller and @ResponseBody
//@Controller
@RequestMapping("/")
public class EnrollmentController {

	@Autowired
	@Qualifier("enrollmentObj")
	Enrollment enrollment;   // dependency injection by property
	
	private EnrollmentService service;
	
//	@Autowired
//	public void setEnrollmentService(EnrollmentService service) {   // dependency injection using setter
//		this.service = service;
//	}
	
	public EnrollmentController(EnrollmentService service) {   //dependency injection using constructor
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	@GetMapping(value="enrollment/list", produces="application/json")
	//public List<Enrollment> getAll(){
	public ResponseEntity<List<Enrollment>> getAll(){
		//return service.getEnrollmentList();
		List<Enrollment> enList = service.getEnrollmentList();
		var headers = new HttpHeaders();
		headers.add("TonysHeader1", "this is a test");
		headers.add("TestHeader2", "test header 2");
		
		return ResponseEntity.accepted().headers(headers).body(enList);				
	}
	
	@GetMapping(value="enrollment/id/{id}", produces="application/json")
	public Enrollment getById(@PathVariable(name="id") int id) {
		return service.findById(id);
	}
	
	//@GetMapping(value="enrollment", produces="text/html")
	@GetMapping(value="enrollment", produces="application/json")
	public Enrollment getUsingQueryPath(@RequestParam(name="id") int id) {
		Enrollment enroll = service.findById(id);
		return enroll;
		//return service.findById(id);
	}

}
