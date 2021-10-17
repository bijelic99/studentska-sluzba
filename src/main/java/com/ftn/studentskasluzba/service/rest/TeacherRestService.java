package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.Teacher;
import com.ftn.studentskasluzba.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherRestService extends RestServiceAbstractClass<Teacher> {

    @Autowired
    public TeacherRestService(TeacherRepository repository) {
        super(repository, new Teacher());
    }
}
