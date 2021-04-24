package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@Entity
public class CourseAdditionalPointsEnrolment extends BaseAbstractClass {
    @ManyToOne
    @JoinColumn(name = "course_additional_points_id")
    private CourseAdditionalPoints courseAdditionalPoints;
    @ManyToOne
    @JoinColumn(name = "course_enrolment_id")
    private CourseEnrolment courseEnrolment;
    private Integer points;
    private Boolean passed;
}
