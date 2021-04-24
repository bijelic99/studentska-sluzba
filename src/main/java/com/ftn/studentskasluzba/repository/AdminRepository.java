package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
