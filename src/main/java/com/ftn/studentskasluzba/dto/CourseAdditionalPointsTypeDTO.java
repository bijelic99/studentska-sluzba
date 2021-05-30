package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.CourseAdditionalPointsType;

import java.util.HashSet;

public record CourseAdditionalPointsTypeDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        String name
) implements ToModel<CourseAdditionalPointsType> {

    public CourseAdditionalPointsTypeDTO(CourseAdditionalPointsType courseAdditionalPointsType) {
        this(courseAdditionalPointsType.getId(), courseAdditionalPointsType.getName());
    }

    @Override
    public CourseAdditionalPointsType toModel() {
        return new CourseAdditionalPointsType(id, name, new HashSet<>());
    }
}
