package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.ExamEnrolment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamEnrolmentRepository extends JpaRepository<ExamEnrolment, Long> {
}
