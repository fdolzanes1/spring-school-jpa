package com.dolzanes.school.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dolzanes.school.entity.Course;
import com.dolzanes.school.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository repository;
	
	@Test
	public void SaveCourseMaterial() {
		Course course = Course
				.builder()
				.title("DSA")
				.credit(6)
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial
				.builder()
				.url("www.google.com")
				.course(course)
				.build();
		
		repository.save(courseMaterial);
	}

}
