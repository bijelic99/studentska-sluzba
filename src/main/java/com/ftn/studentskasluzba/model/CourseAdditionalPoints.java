package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class CourseAdditionalPoints {
    private Long id;
    private String name;
    private Course course;
    private CourseAdditionalPointsType courseAdditionalPointsType;
    private Set<CourseAdditionalPointsEnrolment> courseAdditionalPointsEnrolments;
}
