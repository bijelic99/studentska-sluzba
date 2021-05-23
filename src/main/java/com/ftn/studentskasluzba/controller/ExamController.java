package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.ExamDTO;
import com.ftn.studentskasluzba.repository.ExamRepository;
import com.ftn.studentskasluzba.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
