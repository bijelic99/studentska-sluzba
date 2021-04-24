package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class Employee extends BaseAbstractClass implements ApplicationUser {
    @Embedded
    private UserGeneralData userGeneralData;
    @OneToMany(mappedBy = "employee")
    private Set<Teacher> teacherPositions = new HashSet<>();
}
