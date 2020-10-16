package com.example.springboot.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Student;
import com.example.springboot.repository.StudentRepoUsingJdbcTemplate;
import com.example.springboot.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	@Autowired
	StudentRepoUsingJdbcTemplate repository2;
	
//	@Autowired
//	Student student;
	
	public StudentService() {
		// TODO Auto-generated constructor stub
	}

	public Student save(Student student) {
		return repository.save(student);
	}
	
	public List<Student> getStudentList(String attributeName, String sortOrder){
		if (sortOrder.equalsIgnoreCase("desc")) {
			//return (List<Student>) repository.findAll(Sort.Order.desc(attributeName));
			return (List<Student>) repository.findAll(Sort.by(Sort.Direction.DESC, attributeName));
		}else {  // default is ascending
			//return (List<Student>) repository.findAll(Sort.Order.asc(attributeName));
			return (List<Student>) repository.findAll(Sort.by(Sort.Direction.ASC, attributeName));
		}
		
	}
	
	public List<Student> getStudentList2(){
		List<Student> studentList = repository2.getAllStudents();
		
		// testing block
		Set<String> nameList = new HashSet<String>(studentList.stream().map(o -> o.getFirstName()+" "+o.getLastName()).filter(name->name.endsWith("Vu")).collect(Collectors.toList()));//.toArray();
		
		for (String name : nameList) {
			log.info("last name: "+name);
		}
		// end testing block
		
		//return repository2.getAllStudents();
		return studentList;
	}
	
	public Optional<Student> getStudent(int id) {
		return repository.findById(id);
	}
	
	public Student findStudent(int id) {
		Optional<Student> student = repository.findById(id);
		
		if (student.isEmpty()) {
			return null;
		}else {
			return student.get();
		}
	}
	
	public void delete(Student student) {
		repository.delete(student);
	}
	
	public List<Student> findByLastname(String lastName){
		return repository.findByLastname(lastName);
	}
	
	public List<Student> findByFirstname(String firstName){
		return repository.findByFirstname(firstName);
	}
	
	public List<String> findById2(int id){
		return repository.findById2(id);
	}
}
