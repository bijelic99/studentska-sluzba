package com.ftn.studentskasluzba.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CourseAdditionalPointsType extends BaseAbstractClass {
    private String name;
    @OneToMany(mappedBy = "courseAdditionalPointsType")
    private Set<CourseAdditionalPoints> courseAdditionalPointsSet = new HashSet<>();

    public CourseAdditionalPointsType(Long id, String name, Set<CourseAdditionalPoints> courseAdditionalPointsSet) {
        super(id);
        this.name = name;
        this.courseAdditionalPointsSet = courseAdditionalPointsSet;
    }
}
