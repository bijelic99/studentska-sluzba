package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.ExamDTO;
import com.ftn.studentskasluzba.dto.ExamEnrolmentDTO;
import com.ftn.studentskasluzba.repository.ExamEnrolmentRepository;
import com.ftn.studentskasluzba.repository.ExamRepository;
import com.ftn.studentskasluzba.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/exams")
public class ExamController {
    @Autowired
    ExamService examService;

    @Autowired
    ExamRepository examRepository;

    @Autowired
    ExamEnrolmentRepository examEnrolmentRepository;

    @PutMapping
    @PreAuthorize("hasAuthority('ExamCreateAndEdit')")
    public ExamDTO examPut(@RequestBody ExamDTO exam) {
        var providedExam = exam.toModel();
        return new ExamDTO(examService.saveExam(providedExam));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDTO> getExam(@PathVariable("id") Long id) {
        return examRepository.findById(id).map(ExamDTO::new).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/enrolments")
    public Set<ExamEnrolmentDTO> getExamEnrolments(@PathVariable("id") Long id) {
        return examEnrolmentRepository.getExamEnrolments(id).stream().map(ExamEnrolmentDTO::new).collect(Collectors.toSet());
    }
}
