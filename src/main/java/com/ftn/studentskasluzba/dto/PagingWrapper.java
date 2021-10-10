package com.ftn.studentskasluzba.dto;

import java.util.Set;

public record PagingWrapper<Entity>(
        Set<Entity> elements,
        Integer totalPages,
        Long totalResults
) {
}
