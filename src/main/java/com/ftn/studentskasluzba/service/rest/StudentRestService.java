package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentRestService extends RestServiceAbstractClass<Student> {

    @Autowired
    public StudentRestService(StudentRepository repository) {
        super(repository, new Student());
    }

    @Override
    protected Student applyPutChangesToEntity(Student originalEntity, Student changedEntity) {

        originalEntity.setUserGeneralData(changedEntity.getUserGeneralData());
        originalEntity.setStudentsAccount(changedEntity.getStudentsAccount());

        return originalEntity;
    }
}
