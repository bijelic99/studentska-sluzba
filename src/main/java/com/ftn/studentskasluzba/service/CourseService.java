package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.model.Course;
import com.ftn.studentskasluzba.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        var courseToSave = course.getId() == null ? course : courseRepository.findById(course.getId()).map(existingCourse -> {
            course.setTeachers(existingCourse.getTeachers());
            course.setCourseAdditionalPoints(existingCourse.getCourseAdditionalPoints());
            course.setExams(existingCourse.getExams());
            course.setCourseEnrolments(existingCourse.getCourseEnrolments());
            return course;
        }).orElseThrow();
        return courseRepository.save(courseToSave);
    }
}
