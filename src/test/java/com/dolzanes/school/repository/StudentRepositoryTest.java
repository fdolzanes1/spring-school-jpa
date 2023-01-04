package com.dolzanes.school.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dolzanes.school.entity.Guardian;
import com.dolzanes.school.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository repository;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
							.emailId("fabiano@mail.com")
							.firstName("Fabiano")
							.lastName("Dolzanes")
							.build();
		repository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardian() {

	    Guardian guardian = Guardian.builder()
	            .email("nikhil@gmail.com")
	            .name("Nikhil")
	            .mobile("9999956324")
	            .build();
	
	    Student student = Student.builder()
	            .firstName("Shivam")
	            .emailId("shivam@gmail.com")
	            .lastName("Kumar")
	            .guardian(guardian)
	            .build();
	
	    repository.save(student);
	}
	
	@Test
	public void printAllStudent() {
		List<Student> student = repository.findAll();
		System.out.println(student);
	}
	
	@Test
	public void printStudentByFirstName() {
		List<Student> students = repository.findByFirstName("Fabiano");
		System.out.println("Students == "+students);
	}
	
	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> students = repository.findByFirstName("Fab");
		System.out.println("Students == "+students);
	}
	
	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> students = repository.findByGuardianName("Nikhil");
		System.out.println("Students == "+students);
	}
	
	@Test
	public void printStudentByFirstNameAndLastName() {
		Student student = repository.findByFirstNameAndLastName("Fabiano", "Dolzanes");
		System.out.println("Student == "+student);
	}
	
	@Test
	public void printgetStudentByEmailAddress() {
		Student student = repository.getStudentByEmailAddress("fabiano@mail.com");
		System.out.println("Student Email Address== "+student);
	}

	@Test
	public void printgetStudentAll() {
		List<Student> student = repository.getStudentAll();
		System.out.println("Student All == "+student);
	}
	
	@Test
    public void updateStudentNameByEmailIdTest() {
		repository.updateStudentNameByEmailId(
                "FABIANO MEIRELLIS",
                "fabiano@mail.com");
    }
}
