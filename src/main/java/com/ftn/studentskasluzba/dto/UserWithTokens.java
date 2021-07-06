package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserWithTokens(
    @JsonProperty("applicationUser")
    UserWithRole applicationUser,
    @JsonProperty("jwtToken")
    String jwtToken,
    @JsonProperty("refreshToken")
    String refreshToken
) {
}
