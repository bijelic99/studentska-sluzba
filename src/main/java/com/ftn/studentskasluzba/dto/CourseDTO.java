package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Course;
import org.joda.time.DateTime;

import java.util.HashSet;

public record CourseDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime endDate,
        @JsonProperty
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime startDate,
        @JsonProperty
        SubjectDTO subject) implements ToModel<Course> {
    public CourseDTO(Course course) {
        this(course.getId(), course.getEndDate(), course.getStartDate(), new SubjectDTO(course.getSubject()));
    }

    @Override
    public Course toModel() {
        return new Course(id, endDate, startDate, subject.toModel(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>());
    }
}
