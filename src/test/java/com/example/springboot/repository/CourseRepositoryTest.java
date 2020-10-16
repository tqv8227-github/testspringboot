package com.example.springboot.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseRepositoryTest {

	//@BeforeEach
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("set up");
	}

	//@AfterEach
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}
	

	@Test
	void testSave() {
		System.out.println("testSave");
		assertEquals(1, 1);
		
	}

	@Test
	void testSaveAll() {
		System.out.println("testSaveAll");
		assertArrayEquals(new int[] {1}, new int[] {2});
	}

	@Test
	void testFindById() {
		System.out.println("testFindById");		
		
	}

	@Test
	void testExistsById() {
		System.out.println("testExistsById");
	}

	@Test
	void testFindAll() {
		System.out.println("testFindAll");
	}

	@Test
	void testFindAllById() {
		//fail("Not yet implemented");
		System.out.println("testFindAllById");
	}

	@Test
	void testCount() {
		//fail("Not yet implemented");
		System.out.println("testCount");
	}

	@Test
	void testDeleteById() {
		//fail("Not yet implemented");
		System.out.println("testDeleteById");
	}

	@Test
	void testDelete() {
		//fail("Not yet implemented");
		System.out.println("testDelete");
	}

	@Test
	void testDeleteAllIterableOfQextendsT() {
		//fail("Not yet implemented");
		System.out.println("testDeleteAllIterableOfQextendsT");
	}

	@Test
	void testDeleteAll() {
		//fail("Not yet implemented");
		System.out.println("testDeleteAll");
	}

}
