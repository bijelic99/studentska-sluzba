package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.Employee;
import com.ftn.studentskasluzba.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRestService extends RestServiceAbstractClass<Employee> {

    @Autowired
    public EmployeeRestService(EmployeeRepository repository) {
        super(repository, new Employee());
    }

    @Override
    protected Employee applyPutChangesToEntity(Employee originalEntity, Employee changedEntity) {
        originalEntity.setUserGeneralData(changedEntity.getUserGeneralData());
        return originalEntity;
    }
}
