package com.ftn.studentskasluzba.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CourseAdditionalPoints extends BaseAbstractClass {
    private String name;
    private Boolean passRequired;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime startDatetime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime endDatetime;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "course_additional_points_type_id")
    private CourseAdditionalPointsType courseAdditionalPointsType;
    @OneToMany(mappedBy = "courseAdditionalPoints")
    private Set<CourseAdditionalPointsEnrolment> courseAdditionalPointsEnrolments = new HashSet<>();

    public CourseAdditionalPoints(Long id, String name, Boolean passRequired, DateTime startDatetime, DateTime endDatetime, Course course, CourseAdditionalPointsType courseAdditionalPointsType, Set<CourseAdditionalPointsEnrolment> courseAdditionalPointsEnrolments, Boolean deleted) {
        super(id, deleted);
        this.name = name;
        this.passRequired = passRequired;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.course = course;
        this.courseAdditionalPointsType = courseAdditionalPointsType;
        this.courseAdditionalPointsEnrolments = courseAdditionalPointsEnrolments;
    }
}
