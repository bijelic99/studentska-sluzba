package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Tokens(
        @JsonProperty("refreshToken")
        String refreshToken,
        @JsonProperty("jwtToken")
        String jwtToken
) {
}
