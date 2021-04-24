package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
