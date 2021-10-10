package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TeachingRole extends BaseAbstractClass {
    private String name;
    @OneToMany(mappedBy = "teachingRole")
    private Set<Teacher> teachers = new HashSet<>();

    public TeachingRole(Long id, String name, Set<Teacher> teachers, Boolean deleted) {
        super(id, deleted);
        this.name = name;
        this.teachers = teachers;
    }
}
