package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.Admin;
import com.ftn.studentskasluzba.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends RestServiceAbstractClass<Admin>{

    @Autowired
    public AdminService(AdminRepository repository) {
        super(repository, new Admin());
    }
}
