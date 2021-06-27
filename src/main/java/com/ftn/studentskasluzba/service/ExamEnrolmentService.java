package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.model.ExamEnrolment;
import com.ftn.studentskasluzba.repository.ExamEnrolmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamEnrolmentService {

    @Autowired
    ExamEnrolmentRepository examEnrolmentRepository;

    public ExamEnrolment saveEnrolment(ExamEnrolment enrolment) {
        var enrolmentToSave = enrolment.getId() == null ? enrolment : examEnrolmentRepository.findById(enrolment.getId()).map( existingEnrolment -> {
            existingEnrolment.setGrade(enrolment.getGrade());
            existingEnrolment.setPoints(enrolment.getPoints());
            return existingEnrolment;
        }).orElseThrow();

        return examEnrolmentRepository.save(enrolmentToSave);
    }
}
