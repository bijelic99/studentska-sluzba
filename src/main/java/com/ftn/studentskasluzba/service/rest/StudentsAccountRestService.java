package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.StudentsAccount;
import com.ftn.studentskasluzba.repository.StudentsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsAccountRestService extends RestServiceAbstractClass<StudentsAccount> {

    @Autowired
    public StudentsAccountRestService(StudentsAccountRepository repository) {
        super(repository, new StudentsAccount());
    }

    @Override
    protected StudentsAccount applyPutChangesToEntity(StudentsAccount originalEntity, StudentsAccount changedEntity) {

        originalEntity.setAmount(changedEntity.getAmount());
        originalEntity.setStudent(changedEntity.getStudent());

        return originalEntity;
    }
}
