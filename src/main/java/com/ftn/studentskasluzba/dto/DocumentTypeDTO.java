package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.DocumentType;

import java.util.HashSet;

public record DocumentTypeDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<DocumentType, DocumentTypeDTO> {
    public DocumentTypeDTO(DocumentType documentType) {
        this(documentType.getId(), documentType.getName(), documentType.getDeleted());
    }


    @Override
    public DocumentType toModel() {
        return new DocumentType(id, name, new HashSet<>(), deleted);
    }


    @Override
    public DocumentTypeDTO fromModel(DocumentType modelObject) {
        return new DocumentTypeDTO(modelObject);
    }
}
