package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NewUserDTO(
        @JsonProperty("registerToken")
        String registerToken,
        @JsonProperty("email")
        String email,
        @JsonProperty("username")
        String username,
        @JsonProperty("firstName")
        String firstName,
        @JsonProperty("lastName")
        String lastName,
        @JsonProperty("password")
        String password
) {
}
