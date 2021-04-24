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
public class TeachingRole extends BaseAbstractClass {
    private String name;
    @OneToMany(mappedBy = "teachingRole")
    private Set<Teacher> teachers = new HashSet<>();
}
