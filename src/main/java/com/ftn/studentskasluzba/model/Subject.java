package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject extends BaseAbstractClass {
    private String title;
    private Integer ECTS;
    @OneToMany(mappedBy = "subject")
    private Set<Course> courses = new HashSet<>();
}
