package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
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
}
