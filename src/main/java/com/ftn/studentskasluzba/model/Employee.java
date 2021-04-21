package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Employee implements ApplicationUser {
    private Long id;
    private UserGeneralData userGeneralData;
    private Set<Teacher> teacherPositions;
}
