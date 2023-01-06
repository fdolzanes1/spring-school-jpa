package com.dolzanes.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dolzanes.school.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
