package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Student implements ApplicationUser{
    private Long id;
    private UserGeneralData userGeneralData;
    private StudentsAccount studentsAccount;
    private Set<StudentsDocument> studentsDocuments;
    private Set<CourseEnrolment> courseEnrolments;
}
