package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Student;
import com.example.springboot.repository.StudentRepository;
import com.example.springboot.service.StudentService;

import ch.qos.logback.classic.Logger;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j    // simple log farcade
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	@Qualifier("studentObj2")
	Student newStudent;
	
	@Autowired
	StudentService service;
	
	//@RequestMapping("/")
	@GetMapping(value="hello")
	public String index() {	
		try {
			Student myStudent = (Student) newStudent.clone();  // clone student
			List<String> test = Arrays.asList(new String[] {"1","2"});   // convert array to list
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping(value="find")
	public List<String> findById(@RequestParam int id){
		return service.findById2(id);
	}
	
	@GetMapping(value="list/sortby/{attributename}/order/{sortorder}", produces="application/json")
	public List<Student> getStudentList(@PathVariable(value="attributename") String attributeName, 
										@PathVariable(value="sortorder") String sortOrder){
		return service.getStudentList(attributeName, sortOrder);
	}
	
	@GetMapping(value="list2", produces="application/json")
	public List<Student> getStudent2(){
		return service.getStudentList2();
	}
	
	@GetMapping(value="lastname/{lastname}", produces="application/json")
	public List<Student> getStudentsByLastName(@PathVariable(value="lastname") String lastName){
		return service.findByLastname(lastName);
	}
	
	@GetMapping(value="firstname/{firstname}", produces="application/json")
	public List<Student> getStudentsByFirstName(@PathVariable(value="firstname") String firstName){
		return service.findByFirstname(firstName);
	}
	
	@GetMapping(value="findbyid", produces="application/json")
	public ResponseEntity<Student> getStudentById(@RequestParam(value="id", required=true) int myId, 
													HttpServletResponse response, HttpServletRequest request){
		Student student = service.findStudent(myId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("myheader1" , "Test value 1");
		Cookie[] cookieList = request.getCookies();
		
		if (cookieList !=  null) {
			for (Cookie thisCookie: cookieList) {
				log.info("name: "+thisCookie.getName()+", value: "+thisCookie.getValue());
			}
		}else {
			log.info("No Cookies found");
		}
		
		Cookie cookie = new Cookie("xxx","xxxVal");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(1);
		response.addCookie(cookie);
		
		return ResponseEntity.accepted().headers(headers).body(student);
	}
	
	@PostMapping(value="create", produces="application/json", consumes="application/json")
	public Student createNewStudent(@RequestBody(required=true) Student student) {
		
		// add new student to database
		//newStudent = new Student();
		newStudent.setId(student.getId());
		newStudent.setFirstName(student.getFirstName());
		newStudent.setLastName(student.getLastName());
		newStudent.setSex(student.getSex());
		newStudent.setDob(LocalDate.now());
		
		service.save(newStudent);
		
		return newStudent;
		
	}
	
	@DeleteMapping(value="delete/{id}")
	public Student deleteStudent(@PathVariable(name="id") int id) {
		Optional<Student> student = service.getStudent(id);
		
		student.ifPresent(user-> {service.delete(user);});
		return student.get();
	}
	
	@PutMapping(value="update", produces="application/json")
	public Student updateStudent(@RequestBody(required=true) Student student) {
		Optional<Integer> studentId = Optional.ofNullable(student.getId());
		
		studentId.ifPresent(id -> {service.save(student);});
		return student;
	}
}