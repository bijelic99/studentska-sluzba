package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
