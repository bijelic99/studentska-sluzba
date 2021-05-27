package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Teacher;

public record TeacherDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        CourseDTO course,
        @JsonProperty
        EmployeeDTO employee,
        @JsonProperty
        TeachingRoleDTO teachingRole
) implements ToModel<Teacher> {

    public TeacherDTO(Teacher teacher){
        this(teacher.getId(), new CourseDTO(teacher.getCourse()), new EmployeeDTO(teacher.getEmployee()), new TeachingRoleDTO(teacher.getTeachingRole()));
    }

    @Override
    public Teacher toModel() {
        return new Teacher(id, course.toModel(), employee.toModel(), teachingRole.toModel());
    }
}
