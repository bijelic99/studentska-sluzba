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

    @Value("${enrollmentFee:200}")
    private Double enrollmentFee;

    public Exam saveExam(Exam exam) {
        var examToSave = examRepository.findById(exam.getId()).map(existingExam -> {
            exam.setExamEnrolments(existingExam.getExamEnrolments());
            exam.setExamEnrolmentFee(enrollmentFee);
            return exam;
        }).orElse(exam);
        return examRepository.save(examToSave);
    }
}
