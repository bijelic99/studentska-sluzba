package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseAdditionalPointsEnrolment {
    private Long id;
    private CourseAdditionalPoints courseAdditionalPoints;
    private Integer points;
    private Boolean passed;
}
