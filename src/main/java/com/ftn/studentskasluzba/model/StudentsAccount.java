package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class StudentsAccount extends BaseAbstractClass {
    private Double amount;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @OneToMany(mappedBy = "account")
    private Set<Payment> payments = new HashSet<>();
    @OneToMany(mappedBy = "account")
    private Set<Expense> expenses = new HashSet<>();
}
