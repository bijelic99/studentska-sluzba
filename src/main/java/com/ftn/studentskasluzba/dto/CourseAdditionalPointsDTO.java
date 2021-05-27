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
        CourseDTO course,
        @JsonProperty
        CourseAdditionalPointsTypeDTO courseAdditionalPointsType
) implements ToModel<CourseAdditionalPoints> {
    public CourseAdditionalPointsDTO(CourseAdditionalPoints courseAdditionalPoints) {
        this(courseAdditionalPoints.getId(), courseAdditionalPoints.getName(), new CourseDTO(courseAdditionalPoints.getCourse()), new CourseAdditionalPointsTypeDTO(courseAdditionalPoints.getCourseAdditionalPointsType()));
    }

    @Override
    public CourseAdditionalPoints toModel() {
        return new CourseAdditionalPoints(
                id,
                name,
                course.toModel(),
                courseAdditionalPointsType.toModel(),
                new HashSet<>()
        );
    }
}
