package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.CourseAdditionalPointsDTO;
import com.ftn.studentskasluzba.dto.CourseAdditionalPointsEnrolmentDTO;
import com.ftn.studentskasluzba.repository.CourseAdditionalPointsRepository;
import com.ftn.studentskasluzba.service.CourseAdditionalPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/course-additional-points")
public class CourseAdditionalPointsController {

    @Autowired
    CourseAdditionalPointsRepository courseAdditionalPointsRepository;

    @Autowired
    CourseAdditionalPointsService courseAdditionalPointsService;

    @PutMapping
    @PreAuthorize("hasAuthority('CourseAdditionalPointsCreateAndEdit')")
    public CourseAdditionalPointsDTO putCourseAdditionalPoints(@RequestBody CourseAdditionalPointsDTO courseAdditionalPoints) {
        var providedCourseAdditionalPoints = courseAdditionalPoints.toModel();

        return new CourseAdditionalPointsDTO(courseAdditionalPointsService.saveCourseAdditionalPoints(providedCourseAdditionalPoints));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseAdditionalPointsDTO> getAdditionalPoints(@PathVariable("id") Long id) {
        return courseAdditionalPointsRepository
                .findById(id)
                .map(CourseAdditionalPointsDTO::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/enrolments")
    public Collection<CourseAdditionalPointsEnrolmentDTO> getAdditionalPointsEnrolments(@PathVariable("id") Long id) {
        return courseAdditionalPointsRepository
                .findById(id)
                .stream()
                .flatMap(x->x.getCourseAdditionalPointsEnrolments().stream())
                .map(CourseAdditionalPointsEnrolmentDTO::new)
                .collect(Collectors.toSet());
    }

}
