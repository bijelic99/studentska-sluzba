package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.model.StudentsAccount;

import java.util.HashSet;

public record StudentsAccountDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("studentId")
        Long studentId,
        @JsonProperty("amount")
        Double amount,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<StudentsAccount, StudentsAccountDTO> {

    public StudentsAccountDTO(StudentsAccount studentsAccount) {
        this(studentsAccount.getId(), studentsAccount.getStudent().getId(), studentsAccount.getAmount(), studentsAccount.getDeleted());
    }

    @Override
    public StudentsAccount toModel() {
        var st = new Student();
        st.setId(studentId);
        return new StudentsAccount(id, amount, st, new HashSet<>(), new HashSet<>(), deleted);
    }

    @Override
    public StudentsAccountDTO fromModel(StudentsAccount modelObject) {
        return new StudentsAccountDTO(modelObject);
    }
}
