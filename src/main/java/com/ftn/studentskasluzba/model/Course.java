package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.Set;

@Data
@AllArgsConstructor
public class Course {
    private Long id;
    private DateTime endDate;
    private DateTime startDate;
    private Subject subject;
    private Set<Teacher> teachers;
    private Set<CourseAdditionalPoints> courseAdditionalPoints;
    private Set<Exam> exams;
    private Set<CourseEnrolment> courseEnrolments;
}
