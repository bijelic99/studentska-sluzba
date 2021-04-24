package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.StudentsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsAccountRepository extends JpaRepository<StudentsAccount, Long> {
}
