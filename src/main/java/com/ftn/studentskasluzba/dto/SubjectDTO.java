package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Subject;

public record SubjectDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("title")
        String title,
        @JsonProperty("ECTS")
        Integer ECTS
) {
    public SubjectDTO(Subject subject) {
        this(subject.getId(), subject.getTitle(), subject.getECTS());
    }
}
