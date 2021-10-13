package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.DocumentType;
import com.ftn.studentskasluzba.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeRestService extends RestServiceAbstractClass<DocumentType> {

    @Autowired
    public DocumentTypeRestService(DocumentTypeRepository repository) {
        super(repository, new DocumentType());
    }

}
