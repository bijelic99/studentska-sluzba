package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.Exam;
import com.ftn.studentskasluzba.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamRestService extends RestServiceAbstractClass<Exam> {

    @Autowired
    public ExamRestService(ExamRepository repository) {
        super(repository, new Exam());
    }

    @Override
    protected Exam applyPutChangesToEntity(Exam originalEntity, Exam changedEntity) {
        originalEntity.setExamDateTime(changedEntity.getExamDateTime());
        originalEntity.setExamEnrolmentFee(changedEntity.getExamEnrolmentFee());
        originalEntity.setCourse(changedEntity.getCourse());
        originalEntity.setExamPeriod(changedEntity.getExamPeriod());
        return originalEntity;
    }
}
