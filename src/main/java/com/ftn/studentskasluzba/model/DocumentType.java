package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class DocumentType extends BaseAbstractClass {
    private String name;
    @OneToMany(mappedBy = "documentType")
    private Set<StudentsDocument> studentsDocumentSet = new HashSet<>();

    public DocumentType(Long id, String name, Set<StudentsDocument> studentsDocumentSet, Boolean deleted) {
        super(id, deleted);
        this.name = name;
        this.studentsDocumentSet = studentsDocumentSet;
    }
}
