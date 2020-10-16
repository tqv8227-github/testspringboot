package com.example.springboot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.entity.Student;
import com.example.springboot.entity.StudentRowMapper;

@Repository
public class StudentRepoUsingJdbcTemplate {

	//@Autowired
	JdbcTemplate template;
	
	public StudentRepoUsingJdbcTemplate(JdbcTemplate template)  // DI using constructor
	{
		// TODO Auto-generated constructor stub
		this.template = template;
	}
	
	//@Transactional(readOnly=true)
	public List<Student> getAllStudents(){
		String sqlStmt = "select * from students;";
		
		List<Student> studentList = template.query(sqlStmt, new StudentRowMapper());
		return studentList;
	}

}
