package com.ftn.studentskasluzba.dto;

import com.ftn.studentskasluzba.model.BaseAbstractClass;

public interface ToModel<Model extends BaseAbstractClass> {
    Model toModel();
}
