package com.ftn.studentskasluzba.model.security;

import org.springframework.security.core.GrantedAuthority;

public class TeacherDelete implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "TeacherDelete";
    }
}
