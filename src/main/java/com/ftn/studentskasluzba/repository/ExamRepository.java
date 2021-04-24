package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
