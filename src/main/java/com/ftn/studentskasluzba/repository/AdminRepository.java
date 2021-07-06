package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Admin;
import com.ftn.studentskasluzba.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("select u from Admin u where u.userGeneralData.username = :username")
    Optional<ApplicationUser> findByUsername(@Param("username") String username);
}
