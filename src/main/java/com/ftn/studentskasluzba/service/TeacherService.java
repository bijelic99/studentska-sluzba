package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.model.Course;
import com.ftn.studentskasluzba.repository.TeacherRepository;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Set<Course> getTeachersOngoingCourses(Long teacherId) {
        return teacherRepository.getTeachersCourses(teacherId)
                .stream()
                .filter(c -> new Interval(c.getEndDate(), c.getStartDate()).containsNow())
                .collect(Collectors.toSet());
    }
}
