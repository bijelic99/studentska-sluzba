package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.StudentsDocument;

public record StudentsDocumentDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("student")
        StudentDTO student,
        @JsonProperty("url")
        String url,
        @JsonProperty("documentType")
        DocumentTypeDTO documentType,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<StudentsDocument, StudentsDocumentDTO> {
    public StudentsDocumentDTO(StudentsDocument studentsDocument) {
        this(studentsDocument.getId(), new StudentDTO(studentsDocument.getStudent()), studentsDocument.getUrl(), new DocumentTypeDTO(studentsDocument.getDocumentType()), studentsDocument.getDeleted());
    }

    @Override
    public StudentsDocument toModel() {
        return new StudentsDocument(id, url, documentType.toModel(), student.toModel(), deleted);
    }

    @Override
    public StudentsDocumentDTO fromModel(StudentsDocument modelObject) {
        return new StudentsDocumentDTO(modelObject);
    }
}
