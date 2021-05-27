package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.ExamEnrolment;

public record ExamEnrolmentDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        ExamDTO exam,
        @JsonProperty
        CourseEnrolmentDTO courseEnrolment,
        @JsonProperty
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
