package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.CourseEnrolment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseEnrolmentRepository extends JpaRepository<CourseEnrolment, Long> {
}
