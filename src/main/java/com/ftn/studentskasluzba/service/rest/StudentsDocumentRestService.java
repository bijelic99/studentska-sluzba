package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.StudentsDocument;
import com.ftn.studentskasluzba.repository.StudentsDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsDocumentRestService extends RestServiceAbstractClass<StudentsDocument> {

    @Autowired
    public StudentsDocumentRestService(StudentsDocumentRepository repository) {
        super(repository, new StudentsDocument());
    }

}
