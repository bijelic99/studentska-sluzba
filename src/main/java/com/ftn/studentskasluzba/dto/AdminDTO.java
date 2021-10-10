package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Admin;
import com.ftn.studentskasluzba.model.Role;
import com.ftn.studentskasluzba.model.UserGeneralData;

public record AdminDTO(
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
        @JsonProperty("role")
        Role role,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<Admin, AdminDTO>, UserWithRole {
    public AdminDTO(Admin admin) {
        this(
                admin.getId(),
                admin.getUserGeneralData().getEmail(),
                admin.getUserGeneralData().getUsername(),
                admin.getUserGeneralData().getFirstName(),
                admin.getUserGeneralData().getLastName(),
                Role.ADMIN,
                admin.getDeleted()
        );
    }

    @Override
    public Admin toModel() {
        return new Admin(id, new UserGeneralData(email, username, null, firstName, lastName), deleted);
    }

    @Override
    public AdminDTO fromModel(Admin modelObject) {
        return new AdminDTO(modelObject);
    }
}
