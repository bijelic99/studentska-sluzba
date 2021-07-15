package com.ftn.studentskasluzba.model.security;

import org.springframework.security.core.GrantedAuthority;

public class CourseCreateAndEdit implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "CourseCreateAndEdit";
    }
}
