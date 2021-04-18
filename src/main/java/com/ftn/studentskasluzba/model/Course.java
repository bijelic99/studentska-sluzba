package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Course {
    private Long id;
    private Subject subject;
    private Set<Teacher> teachers;
}
