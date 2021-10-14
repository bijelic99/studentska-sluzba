package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.ExamPeriod;
import com.ftn.studentskasluzba.repository.ExamPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamPeriodRestService extends RestServiceAbstractClass<ExamPeriod> {

    @Autowired
    public ExamPeriodRestService(ExamPeriodRepository repository) {
        super(repository, new ExamPeriod());
    }

    @Override
    protected ExamPeriod applyPutChangesToEntity(ExamPeriod originalEntity, ExamPeriod changedEntity) {

        originalEntity.setName(changedEntity.getName());
        originalEntity.setStartTime(changedEntity.getStartTime());
        originalEntity.setEndTime(changedEntity.getEndTime());

        return originalEntity;
    }
}
