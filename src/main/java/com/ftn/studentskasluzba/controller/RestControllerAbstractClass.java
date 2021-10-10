package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.dto.ToAndFromModel;
import com.ftn.studentskasluzba.model.BaseAbstractClass;
import com.ftn.studentskasluzba.service.rest.RestServiceAbstractClass;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class RestControllerAbstractClass<BaseEntity extends BaseAbstractClass, Entity extends ToAndFromModel<BaseEntity, Entity>> {

    protected RestControllerAbstractClass() {

    }

    public RestControllerAbstractClass(Set<String> sortableFields, Entity dtoFactoryObject, RestServiceAbstractClass<BaseEntity> service) {
        this.sortableFields = sortableFields;
        this.dtoFactoryObject = dtoFactoryObject;
        this.service = service;
    }

    protected Integer defaultPageSize = 50;
    protected Set<String> sortableFields;
    /**
     * Has to be done this way because of language limitations of Java
     */
    protected Entity dtoFactoryObject;


    protected RestServiceAbstractClass<BaseEntity> service;

    public ResponseEntity<Entity> get(Long id) {
        return service.get(id).map(baseEntity -> dtoFactoryObject.fromModel(baseEntity)).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PagingWrapper<Entity>> getAll(Boolean includeDeleted, Optional<Integer> page, Optional<Integer> pageSize, Optional<String> sortBy, Optional<String> sortOrder) {
        if (sortBy.isPresent() && !sortableFields.contains(sortBy.get())) return ResponseEntity.badRequest().build();
        if (sortOrder.isPresent() && !Arrays.asList("asc", "desc").contains(sortOrder.get()))
            return ResponseEntity.badRequest().build();
        var result = service.getAll(includeDeleted, page, pageSize.orElse(defaultPageSize), sortBy, sortOrder);
        return ResponseEntity.ok(
                new PagingWrapper<Entity>(
                        result.elements().stream().map(dtoFactoryObject::fromModel).collect(Collectors.toSet()),
                        result.totalPages(),
                        result.totalResults()
                )
        );
    }

    public ResponseEntity<Entity> post(Entity entity) {
        var result = service.post(entity.toModel());
        return ResponseEntity.ok(dtoFactoryObject.fromModel(result));
    }

    public ResponseEntity<Entity> put(Entity entity) {
        var result = service.put(entity.toModel());
        return result.map(r -> ResponseEntity.ok(dtoFactoryObject.fromModel(r))).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Boolean> delete(Long id) {
        return service.delete(id) ? ResponseEntity.ok(true) : ResponseEntity.notFound().build();
    }
}
