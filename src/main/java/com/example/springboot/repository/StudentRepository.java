package com.example.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.entity.Student;

@RepositoryRestResource
//@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
//public interface StudentRepository extends CrudRepository<Student, Integer>{
	
	@Query(value="select * from Students s where s.lastname like concat('%',?1,'%')", nativeQuery=true)
	List<Student> findByLastname(String lastName);
	
	@Query(value="select * from Students s where s.firstname like concat('%',?1,'%')", nativeQuery=true)  // using native query
	List<Student> findByFirstname(String firstName);
	
	// custom query
	@Query(value="select student.firstName||' '||student.lastName as fullname from Student student where student.id=?1")  // JPQL
	List<String> findById2(int id);
	
//	@Override
//	@Query(value="select student from Student student")   //JPQL
//	List<Student> findAll(Sort sort);
}