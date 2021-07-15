package com.ftn.studentskasluzba.model.security;

import org.springframework.security.core.GrantedAuthority;

public class ExamEnrolmentCreateAndEdit implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "ExamEnrolmentCreateAndEdit";
    }
}
