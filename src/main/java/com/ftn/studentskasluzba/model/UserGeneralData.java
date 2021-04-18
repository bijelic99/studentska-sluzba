package com.ftn.studentskasluzba.model;

import lombok.*;

@Data
@AllArgsConstructor
public class UserGeneralData {
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
