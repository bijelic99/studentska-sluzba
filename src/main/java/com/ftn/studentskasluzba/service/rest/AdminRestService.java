package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.Admin;
import com.ftn.studentskasluzba.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRestService extends RestServiceAbstractClass<Admin>{

    @Autowired
    public AdminRestService(AdminRepository repository) {
        super(repository, new Admin());
    }

    @Override
    protected Admin applyPutChangesToEntity(Admin originalEntity, Admin changedEntity) {
        changedEntity.setDeleted(originalEntity.getDeleted());
        changedEntity.setId(originalEntity.getId());
        changedEntity.getUserGeneralData().setPassword(originalEntity.getUserGeneralData().getPassword());
        return changedEntity;
    }
}
