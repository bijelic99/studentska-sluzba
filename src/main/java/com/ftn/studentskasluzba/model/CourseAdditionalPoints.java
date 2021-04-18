package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseAdditionalPoints {
    private Long id;
    private String name;
    private CourseAdditionalPointsType courseAdditionalPointsType;
}
