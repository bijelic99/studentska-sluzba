package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class StudentsAccount {
    private Long id;
    private Double amount;
    private Student student;
    private Set<Payment> payments;
    private Set<Expense> expenses;
}
