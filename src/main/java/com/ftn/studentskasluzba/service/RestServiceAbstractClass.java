package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.BaseAbstractClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class RestServiceAbstractClass<Entity extends BaseAbstractClass> {
    JpaRepository<Entity, Long> repository;

    public Optional<Entity> get(Long id) {
        return repository.findById(id);
    }

    public PagingWrapper<Entity> getAll(Boolean includeDeleted, Optional<Integer> page, Integer pageSize, Optional<String> sortBy, Optional<String> sortOrder) {
        Optional<Sort> sortByObj = sortBy.map(arg -> {
            var sort = Sort.by(arg);
            return sortOrder.map(order -> order.equals("asc") ? sort.ascending() : sort.descending()).orElse(sort);
        });
        Pageable pageable = page.<Pageable>map(p -> sortByObj.map(so -> PageRequest.of(p, pageSize, so)).orElse(PageRequest.of(p, pageSize))).orElse(Pageable.unpaged());

        var result = repository.findAll(pageable);

        return new PagingWrapper<>(
                result.filter(e -> includeDeleted || !e.getDeleted()).toSet(),
                result.getTotalPages(),
                result.getTotalElements()
        );
    }

    public Entity post(Entity newEntity) {
        newEntity.setId(null);
        newEntity.setDeleted(false);
        return repository.save(newEntity);
    }

    public Optional<Entity> put(Entity entity) {
        return repository.findById(entity.getId()).map(notImportant -> repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
