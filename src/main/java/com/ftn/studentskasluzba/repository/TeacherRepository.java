package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
