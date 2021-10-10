package com.ftn.studentskasluzba.dto;

import com.ftn.studentskasluzba.model.BaseAbstractClass;

public interface ToAndFromModel<Model extends BaseAbstractClass, Dto extends ToModel<Model>> extends ToModel<Model>, FromModel<Model, Dto> {
}
