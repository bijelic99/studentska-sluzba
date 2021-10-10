package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.CourseAdditionalPoints;
import org.joda.time.DateTime;

import java.util.HashSet;

public record CourseAdditionalPointsDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("passRequired")
        Boolean passRequired,
        @JsonProperty("startDatetime")
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime startDatetime,
        @JsonProperty("endDatetime")
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime endDatetime,
        @JsonProperty("course")
        CourseDTO course,
        @JsonProperty("courseAdditionalPointsType")
        CourseAdditionalPointsTypeDTO courseAdditionalPointsType,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToModel<CourseAdditionalPoints> {
    public CourseAdditionalPointsDTO(CourseAdditionalPoints courseAdditionalPoints) {
        this(courseAdditionalPoints.getId(), courseAdditionalPoints.getName(), courseAdditionalPoints.getPassRequired(), courseAdditionalPoints.getStartDatetime(), courseAdditionalPoints.getEndDatetime(), new CourseDTO(courseAdditionalPoints.getCourse()), new CourseAdditionalPointsTypeDTO(courseAdditionalPoints.getCourseAdditionalPointsType()), courseAdditionalPoints.getDeleted());
    }

    @Override
    public CourseAdditionalPoints toModel() {
        return new CourseAdditionalPoints(
                id,
                name,
                passRequired,
                startDatetime,
                endDatetime,
                course.toModel(),
                courseAdditionalPointsType.toModel(),
                new HashSet<>(),
                deleted
        );
    }
}
