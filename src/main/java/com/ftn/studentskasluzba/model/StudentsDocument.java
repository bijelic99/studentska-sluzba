package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
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
}
