package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.InstructorCourse;

@Repository
public interface InstructrorCourseRepository extends JpaRepository<InstructorCourse, Integer> {

}
