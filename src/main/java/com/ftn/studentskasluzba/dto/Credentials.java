package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Credentials(
        @JsonProperty("username")
        String username,
        @JsonProperty("password")
        String password
) {
}
