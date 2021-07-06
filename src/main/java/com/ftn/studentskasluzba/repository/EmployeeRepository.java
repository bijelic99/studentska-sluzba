package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.ApplicationUser;
import com.ftn.studentskasluzba.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select u from Employee u where u.userGeneralData.username = :username")
    Optional<ApplicationUser> findByUsername(@Param("username") String username);
}
