package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.CourseAdditionalPointsType;

import java.util.HashSet;

public record CourseAdditionalPointsTypeDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        String name,
        @JsonProperty
        Boolean passRequired
) implements ToModel<CourseAdditionalPointsType> {

    public CourseAdditionalPointsTypeDTO(CourseAdditionalPointsType courseAdditionalPointsType) {
        this(courseAdditionalPointsType.getId(), courseAdditionalPointsType.getName(), courseAdditionalPointsType.getPassRequired());
    }

    @Override
    public CourseAdditionalPointsType toModel() {
        return new CourseAdditionalPointsType(id, name, passRequired, new HashSet<>());
    }
}
