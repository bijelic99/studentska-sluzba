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
public class CourseAdditionalPoints extends BaseAbstractClass {
    private String name;
    private Boolean passRequired;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "course_additional_points_type_id")
    private CourseAdditionalPointsType courseAdditionalPointsType;
    @OneToMany(mappedBy = "courseAdditionalPoints")
    private Set<CourseAdditionalPointsEnrolment> courseAdditionalPointsEnrolments = new HashSet<>();

    public CourseAdditionalPoints(Long id, String name, Boolean passRequired, Course course, CourseAdditionalPointsType courseAdditionalPointsType, Set<CourseAdditionalPointsEnrolment> courseAdditionalPointsEnrolments) {
        super(id);
        this.name = name;
        this.passRequired = passRequired;
        this.course = course;
        this.courseAdditionalPointsType = courseAdditionalPointsType;
        this.courseAdditionalPointsEnrolments = courseAdditionalPointsEnrolments;
    }
}
