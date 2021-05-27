package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.model.UserGeneralData;

import java.util.HashSet;

public record StudentDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        String email,
        @JsonProperty
        String username,
        @JsonProperty
        String firstName,
        @JsonProperty
        String lastName,
        @JsonProperty
        StudentsAccountDTO studentsAccount
) implements ToModel<Student> {
    public StudentDTO(Student student) {
        this(student.getId(), student.getUserGeneralData().getEmail(), student.getUserGeneralData().getUsername(), student.getUserGeneralData().getFirstName(), student.getUserGeneralData().getLastName(), new StudentsAccountDTO(student.getStudentsAccount()));
    }

    @Override
    public Student toModel() {
        return new Student(id, new UserGeneralData(email, username, null, firstName, lastName), studentsAccount.toModel(), new HashSet<>(), new HashSet<>());
    }
}
