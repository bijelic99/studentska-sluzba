package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
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

    public CourseEnrolment(Long id, Student student, Course course, Set<CourseAdditionalPointsEnrolment> additionalPointsEnrolments, Set<ExamEnrolment> examEnrolments) {
        super(id);
        this.student = student;
        this.course = course;
        this.additionalPointsEnrolments = additionalPointsEnrolments;
        this.examEnrolments = examEnrolments;
    }

    public CourseEnrolment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}
