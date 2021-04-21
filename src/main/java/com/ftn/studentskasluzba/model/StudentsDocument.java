package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentsDocument {
    private Long id;
    private String title;
    private String url;
    private DocumentType documentType;
    private Student student;
}
