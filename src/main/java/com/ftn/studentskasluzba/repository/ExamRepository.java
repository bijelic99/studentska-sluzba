package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    @Query("Select e from Exam e join e.course c join c.teachers ct join ct.employee emp where emp.id = :id")
    Set<Exam> getTeachersExams(@Param("id") Long id);
}
