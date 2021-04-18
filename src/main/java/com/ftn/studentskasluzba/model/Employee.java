package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee implements ApplicationUser {
    private Long id;
    private UserGeneralData userGeneralData;
}
