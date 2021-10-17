package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.Subject;
import com.ftn.studentskasluzba.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectRestService extends RestServiceAbstractClass<Subject> {

    @Autowired
    public SubjectRestService(SubjectRepository repository) {
        super(repository, new Subject());
    }

    @Override
    protected Subject applyPutChangesToEntity(Subject originalEntity, Subject changedEntity) {

        originalEntity.setTitle(changedEntity.getTitle());
        originalEntity.setECTS(changedEntity.getECTS());

        return originalEntity;
    }
}
