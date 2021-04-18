package com.ftn.studentskasluzba.model;

import java.util.Set;

public class Account {
    private Long id;
    private Double amount;
    private Set<Payment> payments;
    private Set<Expense> expenses;
}
