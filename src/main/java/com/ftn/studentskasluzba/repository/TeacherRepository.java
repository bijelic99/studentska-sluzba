package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.Course;
import com.ftn.studentskasluzba.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select tp.course from Employee e join e.teacherPositions tp where e.id = :id")
    Set<Course> getTeachersCourses(@Param("id") Long id);
}
