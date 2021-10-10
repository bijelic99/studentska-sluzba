package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PagingWrapper<Entity>(
        @JsonProperty("elements")
        List<Entity> elements,
        @JsonProperty("totalPages")
        Integer totalPages,
        @JsonProperty("totalResults")
        Long totalResults
) {
}
