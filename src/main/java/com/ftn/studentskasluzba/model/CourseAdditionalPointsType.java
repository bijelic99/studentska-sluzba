package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CourseAdditionalPointsType extends BaseAbstractClass {
    private String name;
    private Boolean passRequired;
    @OneToMany(mappedBy = "courseAdditionalPointsType")
    private Set<CourseAdditionalPoints> courseAdditionalPointsSet = new HashSet<>();

    public CourseAdditionalPointsType(Long id, String name, Boolean passRequired, Set<CourseAdditionalPoints> courseAdditionalPointsSet) {
        super(id);
        this.name = name;
        this.passRequired = passRequired;
        this.courseAdditionalPointsSet = courseAdditionalPointsSet;
    }
}
