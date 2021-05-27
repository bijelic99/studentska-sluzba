package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.DocumentType;

import java.util.HashSet;

public record DocumentTypeDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        String name
) implements ToModel<DocumentType> {
    public DocumentTypeDTO(DocumentType documentType) {
        this(documentType.getId(), documentType.getName());
    }


    @Override
    public DocumentType toModel() {
        return new DocumentType(id, name, new HashSet<>());
    }
}
