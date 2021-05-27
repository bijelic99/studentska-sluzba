package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.model.StudentsAccount;

import java.util.HashSet;

public record StudentsAccountDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        Long studentId,
        @JsonProperty
        Double amount
) implements ToModel<StudentsAccount> {

    public StudentsAccountDTO(StudentsAccount studentsAccount) {
        this(studentsAccount.getId(), studentsAccount.getStudent().getId(), studentsAccount.getAmount());
    }

    @Override
    public StudentsAccount toModel() {
        var st = new Student();
        st.setId(studentId);
        return new StudentsAccount(id, amount, st, new HashSet<>(), new HashSet<>());
    }
}
