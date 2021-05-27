package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.model.StudentsDocument;

public record StudentsDocumentDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        StudentDTO student,
        @JsonProperty
        String title,
        @JsonProperty
        String url,
        @JsonProperty
        DocumentTypeDTO documentType
) implements ToModel<StudentsDocument> {
    public StudentsDocumentDTO(StudentsDocument studentsDocument) {
        this(studentsDocument.getId(), new StudentDTO(studentsDocument.getStudent()), studentsDocument.getTitle(), studentsDocument.getUrl(), new DocumentTypeDTO(studentsDocument.getDocumentType()));
    }


    @Override
    public StudentsDocument toModel() {
        return new StudentsDocument(id, title, url, documentType.toModel(), student.toModel());
    }
}
