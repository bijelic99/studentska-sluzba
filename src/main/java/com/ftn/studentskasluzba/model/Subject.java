package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class Subject extends BaseAbstractClass {
    private String title;
    private Integer ECTS;
    @OneToMany(mappedBy = "subject")
    private Set<Course> courses = new HashSet<>();
}
