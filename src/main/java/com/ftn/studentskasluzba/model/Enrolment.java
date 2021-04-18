package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Enrolment {
    private Long id;
    private Student student;
    private Course course;
    private Set<CourseAdditionalPointsEnrolment> additionalPointsEnrolments;
    private Set<ExamEnrolment> examEnrolments;
}
