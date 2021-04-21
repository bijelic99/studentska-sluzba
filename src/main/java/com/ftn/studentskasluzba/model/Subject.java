package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Subject {
    private Long id;
    private String title;
    private Integer ECTS;
    private Set<Course> courses;
}
