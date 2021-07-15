package com.ftn.studentskasluzba.model.security;

import org.springframework.security.core.GrantedAuthority;

public class TeacherCreate implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "TeacherCreate";
    }
}
