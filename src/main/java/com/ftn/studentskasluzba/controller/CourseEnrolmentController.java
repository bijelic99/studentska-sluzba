package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.CourseAdditionalPointsEnrolmentDTO;
import com.ftn.studentskasluzba.repository.CourseEnrolmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/course-enrolments")
public class CourseEnrolmentController {

    @Autowired
    CourseEnrolmentRepository courseEnrolmentRepository;

    @GetMapping("/{id}/course-additional-points-enrolments")
    Collection<CourseAdditionalPointsEnrolmentDTO> getCourseAdditionalPointsEnrolments(@PathVariable("id") Long id) {
        return courseEnrolmentRepository.getAdditionalPointsEnrolments(id).stream().map(CourseAdditionalPointsEnrolmentDTO::new).collect(Collectors.toSet());
    }
}
