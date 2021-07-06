package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Role;

public interface UserWithRole {
    Long id();
    String email();
    String username();
    String firstName();
    String lastName();
    Role role();
}
