package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenWrapper(
        @JsonProperty("token")
        String token
) {
}
