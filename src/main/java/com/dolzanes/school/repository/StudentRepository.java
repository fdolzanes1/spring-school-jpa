package com.dolzanes.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dolzanes.school.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByFirstName(String firstName);
	
	List<Student> findByFirstNameContaining(String firstName);
	
	List<Student> findByLastNameNotNull();
	
	List<Student> findByGuardianName(String guardianName);
	
	Student findByFirstNameAndLastName(String firstName, String lastName);
	
	// JPQL
	@Query(value = "select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String EmailId);
	
	// Native Queries
	@Query(value = "SELECT * FROM tbl_students", nativeQuery = true)
	List<Student> getStudentAll();
	
}
