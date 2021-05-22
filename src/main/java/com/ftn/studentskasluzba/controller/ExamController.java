package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.ExamDTO;
import com.ftn.studentskasluzba.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/exams")
public class ExamController {
    @Autowired
    ExamService examService;

    @PutMapping
    public ExamDTO examPut(@RequestBody ExamDTO exam) {
        var providedExam = exam.toModel();
        return new ExamDTO(examService.saveExam(providedExam));
    }
}
