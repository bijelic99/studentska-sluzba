package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.ExamEnrolment;

public record ExamEnrolmentDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("exam")
        ExamDTO exam,
        @JsonProperty("courseEnrolment")
        CourseEnrolmentDTO courseEnrolment,
        @JsonProperty("expense")
        ExpenseDTO expense
) implements ToModel<ExamEnrolment> {

    public ExamEnrolmentDTO(ExamEnrolment examEnrolment) {
        this(examEnrolment.getId(), new ExamDTO(examEnrolment.getExam()), new CourseEnrolmentDTO(examEnrolment.getCourseEnrolment()), new ExpenseDTO(examEnrolment.getExpense()));
    }

    @Override
    public ExamEnrolment toModel() {
        return null;
    }
}
