package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.CourseAdditionalPointsEnrolment;

public record CourseAdditionalPointsEnrolmentDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("courseAdditionalPoints")
        CourseAdditionalPointsDTO courseAdditionalPoints,
        @JsonProperty("courseEnrolment")
        CourseEnrolmentDTO courseEnrolment,
        @JsonProperty("points")
        Integer points,
        @JsonProperty("passed")
        Boolean passed
) implements ToModel<CourseAdditionalPointsEnrolment> {
    public CourseAdditionalPointsEnrolmentDTO(
            CourseAdditionalPointsEnrolment courseAdditionalPointsEnrolment
    ) {
        this(
                courseAdditionalPointsEnrolment.getId(),
                new CourseAdditionalPointsDTO(courseAdditionalPointsEnrolment.getCourseAdditionalPoints()),
                new CourseEnrolmentDTO(courseAdditionalPointsEnrolment.getCourseEnrolment()),
                courseAdditionalPointsEnrolment.getPoints(),
                courseAdditionalPointsEnrolment.getPassed()
        );
    }

    @Override
    public CourseAdditionalPointsEnrolment toModel() {
        return new CourseAdditionalPointsEnrolment(
                id,
                courseAdditionalPoints.toModel(),
                courseEnrolment.toModel(),
                points,
                passed
        );
    }
}
