package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.model.Course;
import com.ftn.studentskasluzba.model.Teacher;
import com.ftn.studentskasluzba.repository.TeacherRepository;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Set<Course> getTeachersOngoingCourses(Long teacherId) {
        return getTeachersCourses(teacherId)
                .stream()
                .filter(c -> new Interval(c.getStartDate(), c.getEndDate()).containsNow())
                .collect(Collectors.toSet());
    }

    public Set<Course> getTeachersCourses(Long teacherId) {
        return teacherRepository.getTeachersCourses(teacherId);
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> removeTeacher(Long id){
        var teacher =  teacherRepository.findById(id);
        if(teacher.isPresent()){
            teacherRepository.deleteById(id);
        }
        return teacher;

    }
}
