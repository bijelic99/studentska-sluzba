package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.CourseAdditionalPointsEnrolment;
import com.ftn.studentskasluzba.model.CourseEnrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CourseEnrolmentRepository extends JpaRepository<CourseEnrolment, Long> {

    @Query("select ape from CourseEnrolment ce join ce.additionalPointsEnrolments ape where ce.id = :id")
    Set<CourseAdditionalPointsEnrolment> getAdditionalPointsEnrolments(@Param("id") Long id);
}
