package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
