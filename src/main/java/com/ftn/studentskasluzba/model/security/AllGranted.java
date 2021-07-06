package com.ftn.studentskasluzba.model.security;

import org.springframework.security.core.GrantedAuthority;

public class AllGranted implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "AllGranted";
    }
}
