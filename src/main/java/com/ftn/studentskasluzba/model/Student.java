package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class Student extends BaseAbstractClass implements ApplicationUser{
    @Embedded
    private UserGeneralData userGeneralData;
    @OneToOne(mappedBy = "student")
    private StudentsAccount studentsAccount;
    @OneToMany(mappedBy = "student")
    private Set<StudentsDocument> studentsDocuments = new HashSet<>();
    @OneToMany(mappedBy = "student")
    private Set<CourseEnrolment> courseEnrolments = new HashSet<>();
}
