package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Role;
import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.model.StudentsAccount;
import com.ftn.studentskasluzba.model.UserGeneralData;

import java.util.HashSet;

public record StudentWithoutAccountDTO(
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
        @JsonProperty("studentsAccountId")
        Long studentsAccountId,
        @JsonProperty("role")
        Role role,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<Student, StudentWithoutAccountDTO>, UserWithRole {
    public StudentWithoutAccountDTO(Student student) {
        this(student.getId(), student.getUserGeneralData().getEmail(), student.getUserGeneralData().getUsername(), student.getUserGeneralData().getFirstName(), student.getUserGeneralData().getLastName(), student.getStudentsAccount().getId(), Role.STUDENT, student.getDeleted());
    }

    @Override
    public Student toModel() {
        var sa = new StudentsAccount();
        sa.setId(studentsAccountId);
        return new Student(id, new UserGeneralData(email, username, null, firstName, lastName), sa, new HashSet<>(), new HashSet<>(), deleted);
    }

    @Override
    public StudentWithoutAccountDTO fromModel(Student modelObject) {
        return new StudentWithoutAccountDTO(modelObject);
    }
}
