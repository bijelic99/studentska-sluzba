package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
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

    public Student(Long id, UserGeneralData userGeneralData, StudentsAccount studentsAccount, Set<StudentsDocument> studentsDocuments, Set<CourseEnrolment> courseEnrolments) {
        super(id);
        this.userGeneralData = userGeneralData;
        this.studentsAccount = studentsAccount;
        this.studentsDocuments = studentsDocuments;
        this.courseEnrolments = courseEnrolments;
    }
}
