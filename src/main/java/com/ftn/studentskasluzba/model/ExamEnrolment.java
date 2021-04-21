package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@AllArgsConstructor
public class ExamEnrolment implements Expense {
    private Long id;
    private Exam exam;
    private CourseEnrolment enrolment;
    private DateTime timestamp;

    @Override
    public Double getAmount() {
        return exam.getExamEnrolmentFee();
    }

    @Override
    public StudentsAccount getAccount() {
        return getEnrolment().getStudent().getStudentsAccount();
    }
}
