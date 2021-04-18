package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    private Long id;
    private Employee employee;
    private TeachingRole teachingRole;
}
