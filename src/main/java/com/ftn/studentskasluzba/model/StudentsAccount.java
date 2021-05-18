package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
