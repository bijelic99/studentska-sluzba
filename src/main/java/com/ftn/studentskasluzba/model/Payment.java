package com.ftn.studentskasluzba.model;

import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Payment extends Transaction {
    public Payment(Long id, DateTime timestamp, Double amount, StudentsAccount account) {
        super(id, timestamp, amount, account);
    }
}
