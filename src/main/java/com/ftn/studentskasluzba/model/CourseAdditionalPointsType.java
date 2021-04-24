package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class CourseAdditionalPointsType extends BaseAbstractClass {
    private String name;
    private Boolean passRequired;
    @OneToMany(mappedBy = "courseAdditionalPointsType")
    private Set<CourseAdditionalPoints> courseAdditionalPointsSet = new HashSet<>();
}
