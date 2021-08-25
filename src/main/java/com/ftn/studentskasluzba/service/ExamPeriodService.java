package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.model.ExamEnrolment;
import com.ftn.studentskasluzba.model.ExamPeriod;
import com.ftn.studentskasluzba.repository.ExamPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamPeriodService {

    @Autowired
    ExamPeriodRepository examPeriodRepository;

    public ExamPeriod saveExamPeriod(ExamPeriod examPeriod) {
        var periodToSave = examPeriod.getId() == null ? examPeriod : examPeriodRepository.findById(examPeriod.getId()).map( existingPeriod -> {
            existingPeriod.setStartTime(examPeriod.getStartTime());
            existingPeriod.setEndTime(examPeriod.getEndTime());
            existingPeriod.setName(examPeriod.getName());
            return examPeriod;
        }).orElseThrow();

        return examPeriodRepository.save(periodToSave);
    }
}
