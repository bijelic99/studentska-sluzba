package com.ftn.studentskasluzba.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

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
public class Course extends BaseAbstractClass {
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime endDate;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime startDate;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @OneToMany(mappedBy = "course")
    private Set<Teacher> teachers = new HashSet<>();
    @OneToMany(mappedBy = "course")
    private Set<CourseAdditionalPoints> courseAdditionalPoints = new HashSet<>();
    @OneToMany(mappedBy = "course")
    private Set<Exam> exams = new HashSet<>();
    @OneToMany(mappedBy = "course")
    private Set<CourseEnrolment> courseEnrolments = new HashSet<>();

    public Course(Long id, DateTime endDate, DateTime startDate, Subject subject, Set<Teacher> teachers, Set<CourseAdditionalPoints> courseAdditionalPoints, Set<Exam> exams, Set<CourseEnrolment> courseEnrolments, Boolean deleted) {
        super(id, deleted);
        this.endDate = endDate;
        this.startDate = startDate;
        this.subject = subject;
        this.teachers = teachers;
        this.courseAdditionalPoints = courseAdditionalPoints;
        this.exams = exams;
        this.courseEnrolments = courseEnrolments;
    }
}
