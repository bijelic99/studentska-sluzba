package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class TeachingRole {
    private Long id;
    private String name;
    private Set<Teacher> teachers;
}
