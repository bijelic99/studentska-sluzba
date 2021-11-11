package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.model.StudentsAccount;

import java.util.HashSet;

public record StudentsAccountDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("student")
        StudentWithoutAccountDTO student,
        @JsonProperty("amount")
        Double amount,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<StudentsAccount, StudentsAccountDTO> {

    public StudentsAccountDTO(StudentsAccount studentsAccount) {
        this(studentsAccount.getId(), new StudentWithoutAccountDTO(studentsAccount.getStudent()), studentsAccount.getAmount(), studentsAccount.getDeleted());
    }

    @Override
    public StudentsAccount toModel() {
        return new StudentsAccount(id, amount, student.toModel(), new HashSet<>(), new HashSet<>(), deleted);
    }

    @Override
    public StudentsAccountDTO fromModel(StudentsAccount modelObject) {
        return new StudentsAccountDTO(modelObject);
    }
}
