package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Admin implements ApplicationUser {
    private Long id;
    private UserGeneralData userGeneralData;
}
