package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.CourseAdditionalPointsType;

import java.util.HashSet;

public record CourseAdditionalPointsTypeDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToModel<CourseAdditionalPointsType> {

    public CourseAdditionalPointsTypeDTO(CourseAdditionalPointsType courseAdditionalPointsType) {
        this(courseAdditionalPointsType.getId(), courseAdditionalPointsType.getName(), courseAdditionalPointsType.getDeleted());
    }

    @Override
    public CourseAdditionalPointsType toModel() {
        return new CourseAdditionalPointsType(id, name, new HashSet<>(), deleted);
    }
}
