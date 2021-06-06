package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.TeachingRole;

import java.util.HashSet;

public record TeachingRoleDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name
) implements ToModel<TeachingRole> {

    public TeachingRoleDTO(TeachingRole teachingRole) {
        this(teachingRole.getId(), teachingRole.getName());
    }

    @Override
    public TeachingRole toModel() {
        return new TeachingRole(id, name, new HashSet<>());
    }
}
