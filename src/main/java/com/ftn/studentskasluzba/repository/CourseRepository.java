package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
