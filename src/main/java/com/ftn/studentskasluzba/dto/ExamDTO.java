package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Exam;
import org.joda.time.DateTime;

import java.util.HashSet;

public record ExamDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("examDateTime")
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime examDateTime,
        @JsonProperty("examEnrolmentFee")
        Double examEnrolmentFee,
        @JsonProperty("course")
        CourseDTO course,
        @JsonProperty("examPeriod")
        ExamPeriodDTO examPeriod
) implements ToModel<Exam> {
    public ExamDTO(Exam exam) {
        this(exam.getId(), exam.getExamDateTime(), exam.getExamEnrolmentFee(), new CourseDTO(exam.getCourse()), new ExamPeriodDTO(exam.getExamPeriod()));
    }

    @Override
    public Exam toModel() {
        return new Exam(id, examDateTime, examEnrolmentFee, course.toModel(), new HashSet<>(), examPeriod.toModel());
    }
}
