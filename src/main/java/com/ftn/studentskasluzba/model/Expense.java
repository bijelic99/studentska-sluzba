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
    public Expense(Long id, DateTime timestamp, Double amount, StudentsAccount account, Boolean deleted) {
        super(id, timestamp, amount, account, deleted);
    }

    public Expense(Long id, DateTime timestamp, Double amount, Boolean deleted) {
        super(id, timestamp, amount, deleted);
    }
}
