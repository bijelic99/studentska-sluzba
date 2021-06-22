package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.ExamEnrolment;

public record ExamEnrolmentDTO(
        @JsonProperty("id")
        Long id,
        Integer grade,
        Integer points,
        @JsonProperty("exam")
        ExamDTO exam,
        @JsonProperty("courseEnrolment")
        CourseEnrolmentDTO courseEnrolment,
        @JsonProperty("expense")
        ExpenseDTO expense
) implements ToModel<ExamEnrolment> {

    public ExamEnrolmentDTO(ExamEnrolment examEnrolment) {
        this(examEnrolment.getId(), examEnrolment.getGrade(), examEnrolment.getPoints(), new ExamDTO(examEnrolment.getExam()), new CourseEnrolmentDTO(examEnrolment.getCourseEnrolment()), new ExpenseDTO(examEnrolment.getExpense()));
    }

    @Override
    public ExamEnrolment toModel() {
        return new ExamEnrolment(id, grade, points, exam.toModel(), courseEnrolment.toModel(), expense.toModel());
    }
}
