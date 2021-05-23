package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.model.Exam;
import com.ftn.studentskasluzba.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    @Autowired
    ExamRepository examRepository;

    @Value("${exam.enrollmentFee:200}")
    private Double enrollmentFee;

    public Exam saveExam(Exam exam) {
        if(exam.getId() == null) exam.setExamEnrolmentFee(enrollmentFee);
        var examToSave = exam.getId() == null ? exam : examRepository.findById(exam.getId()).map(existingExam -> {
            exam.setExamEnrolments(existingExam.getExamEnrolments());
            return exam;
        }).orElseThrow();
        return examRepository.save(examToSave);
    }
}
