package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.TeachingRole;
import com.ftn.studentskasluzba.repository.TeachingRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachingRoleRestService extends RestServiceAbstractClass<TeachingRole> {

    @Autowired
    public TeachingRoleRestService(TeachingRoleRepository repository) {
        super(repository, new TeachingRole());
    }

    @Override
    protected TeachingRole applyPutChangesToEntity(TeachingRole originalEntity, TeachingRole changedEntity) {

        originalEntity.setName(changedEntity.getName());

        return originalEntity;
    }
}
