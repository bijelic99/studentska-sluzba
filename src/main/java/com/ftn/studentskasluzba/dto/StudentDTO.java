package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Role;
import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.model.UserGeneralData;

import java.util.HashSet;

public record StudentDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("email")
        String email,
        @JsonProperty("username")
        String username,
        @JsonProperty("firstName")
        String firstName,
        @JsonProperty("lastName")
        String lastName,
        @JsonProperty("studentsAccount")
        StudentsAccountDTO studentsAccount,
        @JsonProperty("role")
        Role role,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToModel<Student>, UserWithRole {
    public StudentDTO(Student student) {
        this(student.getId(), student.getUserGeneralData().getEmail(), student.getUserGeneralData().getUsername(), student.getUserGeneralData().getFirstName(), student.getUserGeneralData().getLastName(), new StudentsAccountDTO(student.getStudentsAccount()), Role.STUDENT, student.getDeleted());
    }

    @Override
    public Student toModel() {
        return new Student(id, new UserGeneralData(email, username, null, firstName, lastName), studentsAccount.toModel(), new HashSet<>(), new HashSet<>(), deleted);
    }
}
