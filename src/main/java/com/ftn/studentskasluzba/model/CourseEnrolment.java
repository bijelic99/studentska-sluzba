package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class CourseEnrolment extends BaseAbstractClass {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "courseEnrolment")
    private Set<CourseAdditionalPointsEnrolment> additionalPointsEnrolments = new HashSet<>();
    @OneToMany(mappedBy = "courseEnrolment")
    private Set<ExamEnrolment> examEnrolments = new HashSet<>();
}
