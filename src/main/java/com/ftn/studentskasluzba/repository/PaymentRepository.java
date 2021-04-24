package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
