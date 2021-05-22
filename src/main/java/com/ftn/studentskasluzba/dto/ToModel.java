package com.ftn.studentskasluzba.dto;

import com.ftn.studentskasluzba.model.BaseAbstractClass;

public interface ToModel<A extends BaseAbstractClass> {
    A toModel();
}
