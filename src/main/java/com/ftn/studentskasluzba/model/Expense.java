package com.ftn.studentskasluzba.model;

import org.joda.time.DateTime;

public interface Expense {
    Double getAmount();
    DateTime getTimestamp();
    StudentsAccount getAccount();
}
