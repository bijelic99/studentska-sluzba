package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.SubjectDTO;
import com.ftn.studentskasluzba.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping
    public Collection<SubjectDTO> getAllSubjects() {
        return subjectRepository.findAll().stream().map(SubjectDTO::new).collect(Collectors.toSet());
    }
}
