package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Teacher;

public record TeacherDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("course")
        CourseDTO course,
        @JsonProperty("employee")
        EmployeeDTO employee,
        @JsonProperty("teachingRole")
        TeachingRoleDTO teachingRole,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<Teacher, TeacherDTO> {

    public TeacherDTO(Teacher teacher){
        this(teacher.getId(), new CourseDTO(teacher.getCourse()), new EmployeeDTO(teacher.getEmployee()), new TeachingRoleDTO(teacher.getTeachingRole()), teacher.getDeleted());
    }

    @Override
    public Teacher toModel() {
        return new Teacher(id, course.toModel(), employee.toModel(), teachingRole.toModel(), deleted);
    }

    @Override
    public TeacherDTO fromModel(Teacher modelObject) {
        return new TeacherDTO(modelObject);
    }
}
