package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.CourseAdditionalPointsEnrolmentDTO;
import com.ftn.studentskasluzba.repository.CourseAdditionalPointsEnrolmentRepository;
import com.ftn.studentskasluzba.service.CourseAdditionalPointsEnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/course-additional-points-enrolment")
public class CourseAdditionalPointsEnrolmentController {

    @Autowired
    CourseAdditionalPointsEnrolmentRepository courseAdditionalPointsEnrolmentRepository;

    @Autowired
    CourseAdditionalPointsEnrolmentService courseAdditionalPointsEnrolmentService;

    @GetMapping("/{id}")
    public ResponseEntity<CourseAdditionalPointsEnrolmentDTO> getAdditionalPoints(@PathVariable("id") Long id) {
        return courseAdditionalPointsEnrolmentRepository
                .findById(id)
                .map(CourseAdditionalPointsEnrolmentDTO::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public CourseAdditionalPointsEnrolmentDTO putCourseAdditionalPointsEnrolment(@RequestBody CourseAdditionalPointsEnrolmentDTO courseAdditionalPointsEnrolment) {
        var providedEnrolment = courseAdditionalPointsEnrolment.toModel();
        return new CourseAdditionalPointsEnrolmentDTO(courseAdditionalPointsEnrolmentService.saveEnrolment(providedEnrolment));
    }

}
