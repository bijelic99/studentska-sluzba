package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class CourseAdditionalPointsType {
    private Long id;
    private String name;
    private Boolean passRequired;
    private Set<CourseAdditionalPoints> courseAdditionalPointsSet;
}
