package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Admin;
import com.ftn.studentskasluzba.model.Employee;
import com.ftn.studentskasluzba.model.UserGeneralData;

import java.util.HashSet;

public record AdminDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        String email,
        @JsonProperty
        String username,
        @JsonProperty
        String firstName,
        @JsonProperty
        String lastName
) implements ToModel<Admin> {
    public AdminDTO(Admin admin) {
        this(
                admin.getId(),
                admin.getUserGeneralData().getEmail(),
                admin.getUserGeneralData().getUsername(),
                admin.getUserGeneralData().getFirstName(),
                admin.getUserGeneralData().getLastName()
        );
    }

    @Override
    public Admin toModel() {
        return new Admin(id, new UserGeneralData(email, username, null, firstName, lastName));
    }
}
