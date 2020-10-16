package com.example.springboot.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class InstructorCoursesRowMapper implements RowMapper<InstructorCourse>{

	@Override
	public InstructorCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		InstructorCourse obj = new InstructorCourse();
		
		obj.setCourse((Course)rs.getObject("course"));
		obj.setInstructor((Instructor)rs.getObject("instructor"));
		obj.setId(rs.getInt("id"));
		return obj;
	}


}
