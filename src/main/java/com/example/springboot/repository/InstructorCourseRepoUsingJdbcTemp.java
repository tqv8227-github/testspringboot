package com.example.springboot.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.InstructorCourse;
import com.example.springboot.entity.InstructorCoursesRowMapper;

@Repository
public class InstructorCourseRepoUsingJdbcTemp {
	private JdbcTemplate template;
	
	public InstructorCourseRepoUsingJdbcTemp(JdbcTemplate inTemplate) {
		this.template = inTemplate;
	}
	
	/* use RowMapper */
	public InstructorCourse getSingleObj(int id) {
		String sqlStmt = "select * from instructor_courses a where a.id=?";
		
		InstructorCourse obj = (InstructorCourse) template.query(sqlStmt, new Object[] {id}, new InstructorCoursesRowMapper());
		return obj;
	}
	
	/* use BeanPropertyMapper without having to declare RowMapper*/
	public InstructorCourse getSingleObj2(int id) {
		String sqlStmt = "select * from instructor_courses a where a.id=?";
		
		@SuppressWarnings("unchecked")
		InstructorCourse obj = (InstructorCourse) template.query(sqlStmt, new Object[]{id}, new BeanPropertyRowMapper(InstructorCourse.class));
		return obj;
	}

}
