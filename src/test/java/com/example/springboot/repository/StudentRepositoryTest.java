package com.example.springboot.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRep;
	
//	@BeforeAll
//	void doThis() {
//		System.out.println("before class.");
//		
//	}
//	
//	@AfterAll
//	void doThisAfter() {
//		System.out.println("before class.");
//		
//	}
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("before each.");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("after each.");
	}

	@Test
	void testFindById2() {
		//assertEquals(null, studentRep, "Not supposed to be null");
		assertNull(studentRep);
		System.out.println("testFindById2");
	}
	
	@Test
	void testFindMe() {
		System.out.println("test2");
	}

}
