package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.ExamEnrolment;
import com.ftn.studentskasluzba.repository.ExamEnrolmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamEnrolmentRestService extends RestServiceAbstractClass<ExamEnrolment> {

    @Autowired
    public ExamEnrolmentRestService(ExamEnrolmentRepository repository) {
        super(repository, new ExamEnrolment());
    }
}
