package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.ExamPeriodDTO;
import com.ftn.studentskasluzba.repository.ExamPeriodRepository;
import com.ftn.studentskasluzba.service.ExamPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/exam-periods")
public class ExamPeriodController {

    @Autowired
    ExamPeriodRepository examPeriodRepository;

    @Autowired
    ExamPeriodService examPeriodService;

    @GetMapping("/{id}")
    public ResponseEntity<ExamPeriodDTO> get(Long id) {
        return examPeriodRepository
                .findById(id)
                .map(ExamPeriodDTO::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Collection<ExamPeriodDTO> getAll() {
        return examPeriodRepository
                .findAll()
                .stream()
                .map(ExamPeriodDTO::new)
                .collect(Collectors.toSet());
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ExamEnrolmentCreateAndEdit')")
    public ResponseEntity<ExamPeriodDTO> put(ExamPeriodDTO examPeriod) {
        return ResponseEntity.ok(new ExamPeriodDTO(examPeriodService.saveExamPeriod(examPeriod.toModel())));
    }

}
