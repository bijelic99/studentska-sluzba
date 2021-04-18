package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseAdditionalPointsType {
    private Long id;
    private String name;
    private Boolean passRequired;
}
