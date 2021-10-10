package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.TeachingRole;

import java.util.HashSet;

public record TeachingRoleDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<TeachingRole, TeachingRoleDTO> {

    public TeachingRoleDTO(TeachingRole teachingRole) {
        this(teachingRole.getId(), teachingRole.getName(), teachingRole.getDeleted());
    }

    @Override
    public TeachingRole toModel() {
        return new TeachingRole(id, name, new HashSet<>(), deleted);
    }

    @Override
    public TeachingRoleDTO fromModel(TeachingRole modelObject) {
        return new TeachingRoleDTO(modelObject);
    }
}
