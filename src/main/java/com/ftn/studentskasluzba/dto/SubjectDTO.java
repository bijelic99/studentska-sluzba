package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Subject;

import java.util.HashSet;

public record SubjectDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        String title,
        @JsonProperty
        Integer ECTS
) implements ToModel<Subject> {
    public SubjectDTO(Subject subject) {
        this(subject.getId(), subject.getTitle(), subject.getECTS());
    }

    @Override
    public Subject toModel() {
        return new Subject(id, title, ECTS, new HashSet<>());
    }
}
