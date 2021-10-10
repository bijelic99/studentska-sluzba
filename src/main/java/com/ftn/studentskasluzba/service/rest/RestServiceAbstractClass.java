package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.BaseAbstractClass;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

public abstract class RestServiceAbstractClass<Entity extends BaseAbstractClass> {

    protected RestServiceAbstractClass(){

    }

    public RestServiceAbstractClass(JpaRepository<Entity, Long> repository, Entity exampleEntity){
        this.repository = repository;
        exampleEntity.setDeleted(false);
        this.exampleEntityWithDeletedFalse = exampleEntity;
    }

    JpaRepository<Entity, Long> repository;

    /**
     * Has to be done this way because of language limitations of Java
     */
    Entity exampleEntityWithDeletedFalse;

    public Optional<Entity> get(Long id) {
        return repository.findById(id);
    }

    public PagingWrapper<Entity> getAll(Boolean includeDeleted, Optional<Integer> page, Integer pageSize, Optional<String> sortBy, Optional<String> sortOrder) {
        Optional<Sort> sortByObj = sortBy.map(arg -> {
            var sort = Sort.by(arg);
            return sortOrder.map(order -> order.equals("asc") ? sort.ascending() : sort.descending()).orElse(sort);
        });
        Pageable pageable = page.<Pageable>map(p -> sortByObj.map(so -> PageRequest.of(p, pageSize, so)).orElse(PageRequest.of(p, pageSize))).orElse(Pageable.unpaged());

        Page<Entity> result;

        if(!includeDeleted) {
            var exampleMatcher = ExampleMatcher.matching().withMatcher("deleted", exact());
            var exampleEntity = new BaseAbstractClass(null, false){};
            var example = Example.<Entity>of(exampleEntityWithDeletedFalse, exampleMatcher);
            result = repository.findAll(example, pageable);
        } else {
            result = repository.findAll(pageable);
        }

        return new PagingWrapper<>(
                result.toList(),
                result.getTotalPages(),
                result.getTotalElements()
        );
    }

    public Entity post(Entity newEntity) {
        return repository.save(applyPostChangesToEntity(newEntity));
    }

    public Entity applyPostChangesToEntity(Entity entity) {
        entity.setId(null);
        entity.setDeleted(false);
        return entity;
    }

    public Optional<Entity> put(Entity entity) {
        return repository.findById(entity.getId()).map(originalEntity -> repository.save(applyPutChangesToEntity(originalEntity, entity)));
    }

    protected Entity applyPutChangesToEntity(Entity originalEntity, Entity changedEntity) {
        changedEntity.setDeleted(originalEntity.getDeleted());
        changedEntity.setId(originalEntity.getId());
        return changedEntity;
    }

    public Boolean delete(Long id) {
        var entityToDeleteOpt = repository.findById(id);
        if(entityToDeleteOpt.isPresent()) {
            var entityToDelete = entityToDeleteOpt.get();
            entityToDelete.setDeleted(true);
            repository.save(entityToDelete);
            return true;
        } else return false;
    }
}
