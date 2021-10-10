package com.ftn.studentskasluzba.model;

import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Payment extends Transaction {
    public Payment(Long id, DateTime timestamp, Double amount, StudentsAccount account, Boolean deleted) {
        super(id, timestamp, amount, account, deleted);
    }

    public Payment(Long id, DateTime timestamp, Double amount, Boolean deleted) {
        super(id, timestamp, amount, deleted);
    }
}
