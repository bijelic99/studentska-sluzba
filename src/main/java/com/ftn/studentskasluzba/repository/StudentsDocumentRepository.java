package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.StudentsDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsDocumentRepository extends JpaRepository<StudentsDocument, Long> {
}
