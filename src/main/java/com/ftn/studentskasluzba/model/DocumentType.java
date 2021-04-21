package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class DocumentType {
    private Long id;
    private String name;
    private Set<StudentsDocument> studentsDocumentSet;
}
