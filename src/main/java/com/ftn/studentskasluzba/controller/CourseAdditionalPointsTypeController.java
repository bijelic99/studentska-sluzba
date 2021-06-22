package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.CourseAdditionalPointsTypeDTO;
import com.ftn.studentskasluzba.repository.CourseAdditionalPointsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/course-additional-points-types")
public class CourseAdditionalPointsTypeController {

    @Autowired
    CourseAdditionalPointsTypeRepository courseAdditionalPointsTypeRepository;

    @GetMapping
    public Collection<CourseAdditionalPointsTypeDTO> getAll() {
        return courseAdditionalPointsTypeRepository.findAll().stream().map(CourseAdditionalPointsTypeDTO::new).collect(Collectors.toSet());
    }
}
