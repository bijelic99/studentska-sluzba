package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@AllArgsConstructor
public class Payment {
    private Long id;
    private DateTime timestamp;
    private Double amount;
    private StudentsAccount account;
}
