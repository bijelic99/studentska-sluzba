package com.ftn.studentskasluzba.model;

import org.springframework.security.core.userdetails.UserDetails;

public interface ApplicationUser extends UserDetails {
    Long getId();
    UserGeneralData getUserGeneralData();
}
