package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record PagingWrapper<Entity>(
        @JsonProperty("elements")
        Set<Entity> elements,
        @JsonProperty("totalPages")
        Integer totalPages,
        @JsonProperty("totalResults")
        Long totalResults
) {
}
