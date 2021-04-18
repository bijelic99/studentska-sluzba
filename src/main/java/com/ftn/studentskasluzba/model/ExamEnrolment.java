package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamEnrolment implements Expense {
    private Long id;
    private Exam exam;
    private Enrolment enrolment;

    @Override
    public Double getAmount() {
        return exam.getExamEnrolmentFee();
    }
}
