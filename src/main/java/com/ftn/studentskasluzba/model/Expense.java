package com.ftn.studentskasluzba.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Expense extends Transaction {
    public Expense(Long id, DateTime timestamp, Double amount, StudentsAccount account) {
        super(id, timestamp, amount, account);
    }

    public Expense(Long id, DateTime timestamp, Double amount) {
        super(id, timestamp, amount);
    }
}
