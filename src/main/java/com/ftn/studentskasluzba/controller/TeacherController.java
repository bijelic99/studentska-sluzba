package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.CourseDTO;
import com.ftn.studentskasluzba.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/{id}/courses/ongoing")
    public Set<CourseDTO> getTeachersOngoingCourses(@PathVariable("id") Long id) {
        return teacherService.getTeachersOngoingCourses(id).stream().map(CourseDTO::new).collect(Collectors.toSet());
    }

    @GetMapping("/{id}/courses")
    public Set<CourseDTO> getTeachersCourses(@PathVariable("id") Long id) {
        return teacherService.getTeachersCourses(id).stream().map(CourseDTO::new).collect(Collectors.toSet());
    }
}
