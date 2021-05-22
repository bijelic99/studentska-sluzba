package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Teacher extends BaseAbstractClass {
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "teaching_role_id")
    private TeachingRole teachingRole;

    public Teacher(Long id, Course course, Employee employee, TeachingRole teachingRole) {
        super(id);
        this.course = course;
        this.employee = employee;
        this.teachingRole = teachingRole;
    }
}
