package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.CourseAdditionalPointsDTO;
import com.ftn.studentskasluzba.service.CourseAdditionalPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/course-additional-points")
public class CourseAdditionalPointsController {

    @Autowired
    CourseAdditionalPointsService courseAdditionalPointsService;

    @PutMapping
    public CourseAdditionalPointsDTO putCourseAdditionalPoints(@RequestBody CourseAdditionalPointsDTO courseAdditionalPoints) {
        var providedCourseAdditionalPoints = courseAdditionalPoints.toModel();

        return new CourseAdditionalPointsDTO(courseAdditionalPointsService.saveCourseAdditionalPoints(providedCourseAdditionalPoints));
    }

}
