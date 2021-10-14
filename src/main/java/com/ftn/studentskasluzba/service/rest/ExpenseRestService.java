package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.Expense;
import com.ftn.studentskasluzba.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseRestService extends RestServiceAbstractClass<Expense> {

    @Autowired
    public ExpenseRestService(ExpenseRepository repository) {
        super(repository, new Expense());
    }
}
