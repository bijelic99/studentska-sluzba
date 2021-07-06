package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.ApplicationUser;
import com.ftn.studentskasluzba.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select u from Student u where u.userGeneralData.username = :username")
    Optional<ApplicationUser> findByUsername(@Param("username") String username);
}
