package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class StudentsDocument extends BaseAbstractClass {
    private String title;
    private String url;
    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public StudentsDocument(Long id, String title, String url, DocumentType documentType, Student student) {
        super(id);
        this.title = title;
        this.url = url;
        this.documentType = documentType;
        this.student = student;
    }
}
