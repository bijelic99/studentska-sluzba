package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Subject;

import java.util.HashSet;

public record SubjectDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("title")
        String title,
        @JsonProperty("ECTS")
        Integer ECTS,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToModel<Subject> {
    public SubjectDTO(Subject subject) {
        this(subject.getId(), subject.getTitle(), subject.getECTS(), subject.getDeleted());
    }

    @Override
    public Subject toModel() {
        return new Subject(id, title, ECTS, new HashSet<>(), deleted);
    }
}
