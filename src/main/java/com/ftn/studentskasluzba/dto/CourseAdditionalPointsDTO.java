package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.CourseAdditionalPoints;

import java.util.HashSet;

public record CourseAdditionalPointsDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        String name,
        @JsonProperty
        Boolean passRequired,
        @JsonProperty
        CourseDTO course,
        @JsonProperty
        CourseAdditionalPointsTypeDTO courseAdditionalPointsType
) implements ToModel<CourseAdditionalPoints> {
    public CourseAdditionalPointsDTO(CourseAdditionalPoints courseAdditionalPoints) {
        this(courseAdditionalPoints.getId(), courseAdditionalPoints.getName(), courseAdditionalPoints.getPassRequired(), new CourseDTO(courseAdditionalPoints.getCourse()), new CourseAdditionalPointsTypeDTO(courseAdditionalPoints.getCourseAdditionalPointsType()));
    }

    @Override
    public CourseAdditionalPoints toModel() {
        return new CourseAdditionalPoints(
                id,
                name,
                passRequired,
                course.toModel(),
                courseAdditionalPointsType.toModel(),
                new HashSet<>()
        );
    }
}
