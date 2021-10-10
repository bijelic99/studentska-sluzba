package com.ftn.studentskasluzba.dto;

import com.ftn.studentskasluzba.model.BaseAbstractClass;

public interface FromModel <Model extends BaseAbstractClass, Dto extends ToModel<Model>>{
    Dto fromModel(Model modelObject);
}
