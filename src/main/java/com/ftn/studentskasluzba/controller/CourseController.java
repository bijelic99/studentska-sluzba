package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.CourseDTO;
import com.ftn.studentskasluzba.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

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
        }
        catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
