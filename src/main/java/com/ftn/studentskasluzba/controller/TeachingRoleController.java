package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.TeachingRoleDTO;
import com.ftn.studentskasluzba.repository.TeachingRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/teaching-roles")
public class TeachingRoleController {
    @Autowired
    TeachingRoleRepository teachingRoleRepository;

    @GetMapping
    Collection<TeachingRoleDTO> getAll() {
        return teachingRoleRepository.findAll().stream().map(TeachingRoleDTO::new).collect(Collectors.toSet());
    }
}
