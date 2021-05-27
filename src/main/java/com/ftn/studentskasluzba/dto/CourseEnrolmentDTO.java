package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.CourseEnrolment;

import java.util.HashSet;

public record CourseEnrolmentDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        StudentDTO student,
        @JsonProperty
        CourseDTO course
) implements ToModel<CourseEnrolment> {
    public CourseEnrolmentDTO(CourseEnrolment courseEnrolment) {
        this(courseEnrolment.getId(), new StudentDTO(courseEnrolment.getStudent()), new CourseDTO(courseEnrolment.getCourse()));
    }

    @Override
    public CourseEnrolment toModel() {
        return new CourseEnrolment(id, student.toModel(), course.toModel(), new HashSet<>(), new HashSet<>());
    }
}
