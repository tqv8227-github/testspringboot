package com.example.springboot.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentRowMapper implements RowMapper<Student>
{
//	@Autowired
//	@Qualifier("studentObj2")
//	private Student student;
	
//	public StudentRowMapper(Student student) {
//		this.student = student;
//	}
//	@Autowired
//	@Qualifier("studentObj2")
//	public void setStudent(Student student) {
//		this.student=student;
//	}
	
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setFirstName(rs.getString("firstname"));
        student.setLastName(rs.getString("lastname"));
        student.setSex(rs.getString("sex").charAt(0));
        return student;
    }
}

