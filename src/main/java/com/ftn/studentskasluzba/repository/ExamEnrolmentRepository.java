package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.ExamEnrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ExamEnrolmentRepository extends JpaRepository<ExamEnrolment, Long> {

    @Query("select ee from ExamEnrolment ee where ee.exam.id = :id")
    Set<ExamEnrolment> getExamEnrolments(@Param("id") Long id);
}
