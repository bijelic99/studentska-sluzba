package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
