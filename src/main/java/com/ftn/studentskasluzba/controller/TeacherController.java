package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.CourseDTO;
import com.ftn.studentskasluzba.dto.TeacherDTO;
import com.ftn.studentskasluzba.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<TeacherDTO> addTeacher(@RequestBody TeacherDTO teacher) {
        try {
            return ResponseEntity.ok(new TeacherDTO(teacherService.addTeacher(teacher.toModel())));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeacherDTO> deleteTeacher(@PathVariable("id") Long id) {
        return teacherService.removeTeacher(id).map(TeacherDTO::new).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
