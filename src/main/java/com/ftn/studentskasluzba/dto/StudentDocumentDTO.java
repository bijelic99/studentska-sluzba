package com.ftn.studentskasluzba.dto;

import com.ftn.studentskasluzba.model.StudentsDocument;

public record StudentDocumentDTO(String title, String url, DocumentTypeDTO documentType, StudentDTO studentDTO) implements ToModel<StudentsDocument> {

    public StudentDocumentDTO(StudentsDocument studentsDocument) {
        this(studentsDocument.getTitle(), studentsDocument.getUrl(),
                new DocumentTypeDTO(studentsDocument.getDocumentType()), new StudentDTO(studentsDocument.getStudent()));
    }

    @Override
    public StudentsDocument toModel() {
        return new StudentsDocument(title, url, documentType.toModel(), studentDTO.toModel());
    }
}
