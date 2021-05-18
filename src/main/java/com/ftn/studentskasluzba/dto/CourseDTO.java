package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Course;
import org.joda.time.DateTime;

public record CourseDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("endDate")
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime endDate,
        @JsonProperty("startDate")
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime startDate,
        @JsonProperty("subject")
        SubjectDTO subject) {
    public CourseDTO(Course course) {
        this(course.getId(), course.getEndDate(), course.getStartDate(), new SubjectDTO(course.getSubject()));
    }
}
