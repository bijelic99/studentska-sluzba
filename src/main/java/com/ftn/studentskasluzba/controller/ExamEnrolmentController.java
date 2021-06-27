package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.ExamEnrolmentDTO;
import com.ftn.studentskasluzba.repository.ExamEnrolmentRepository;
import com.ftn.studentskasluzba.service.ExamEnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exam-enrolments")
public class ExamEnrolmentController {

    @Autowired
    ExamEnrolmentService examEnrolmentService;

    @Autowired
    ExamEnrolmentRepository examEnrolmentRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ExamEnrolmentDTO> getEnrolment(@PathVariable("id") Long id) {
        return examEnrolmentRepository.findById(id).map(ExamEnrolmentDTO::new).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<ExamEnrolmentDTO> putEnrolment(@RequestBody ExamEnrolmentDTO enrolment) {
        return ResponseEntity.ok(new ExamEnrolmentDTO(examEnrolmentService.saveEnrolment(enrolment.toModel())));
    }

}
