package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.CourseEnrolment;

import java.util.HashSet;

public record CourseEnrolmentDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("student")
        StudentDTO student,
        @JsonProperty("course")
        CourseDTO course,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<CourseEnrolment, CourseEnrolmentDTO> {
    public CourseEnrolmentDTO(CourseEnrolment courseEnrolment) {
        this(courseEnrolment.getId(), new StudentDTO(courseEnrolment.getStudent()), new CourseDTO(courseEnrolment.getCourse()), courseEnrolment.getDeleted());
    }

    @Override
    public CourseEnrolment toModel() {
        return new CourseEnrolment(id, student.toModel(), course.toModel(), new HashSet<>(), new HashSet<>(), deleted);
    }

    @Override
    public CourseEnrolmentDTO fromModel(CourseEnrolment modelObject) {
        return new CourseEnrolmentDTO(modelObject);
    }
}
