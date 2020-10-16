package com.example.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {

}
