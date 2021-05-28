package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.*;
import com.ftn.studentskasluzba.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable("id") Long id) {
        try {
            var course = courseRepository.findById(id).map(CourseDTO::new).orElseThrow();
            return ResponseEntity.ok(course);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/enrolments")
    public ResponseEntity<Collection<CourseEnrolmentDTO>> getCourseEnrolments(@PathVariable("id") Long id) {
        try {
            var enrolments = courseRepository.findById(id).stream()
                    .flatMap(x -> x.getCourseEnrolments().stream())
                    .map(CourseEnrolmentDTO::new)
                    .collect(Collectors.toSet());
            return ResponseEntity.ok(enrolments);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/teachers")
    public ResponseEntity<Collection<TeacherDTO>> getCourseTeachers(@PathVariable("id") Long id) {
        try {
            var teachers = courseRepository.findById(id).stream()
                    .flatMap(x -> x.getTeachers().stream())
                    .map(TeacherDTO::new)
                    .collect(Collectors.toSet());
            return ResponseEntity.ok(teachers);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/exams")
    public ResponseEntity<Collection<ExamDTO>> getCourseExams(@PathVariable("id") Long id) {
        try {
            var exams = courseRepository.findById(id).stream()
                    .flatMap(x -> x.getExams().stream())
                    .map(ExamDTO::new)
                    .collect(Collectors.toSet());
            return ResponseEntity.ok(exams);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/additional-points")
    public ResponseEntity<Collection<CourseAdditionalPointsDTO>> getCourseAdditionalPoints(@PathVariable("id") Long id) {
        try {
            var cap = courseRepository.findById(id).stream()
                    .flatMap(x -> x.getCourseAdditionalPoints().stream())
                    .map(CourseAdditionalPointsDTO::new)
                    .collect(Collectors.toSet());
            return ResponseEntity.ok(cap);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
