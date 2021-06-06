package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.EmployeeDTO;
import com.ftn.studentskasluzba.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    Collection<EmployeeDTO> getAll() {
        return employeeRepository.findAll().stream().map(EmployeeDTO::new).collect(Collectors.toSet());
    }
}
