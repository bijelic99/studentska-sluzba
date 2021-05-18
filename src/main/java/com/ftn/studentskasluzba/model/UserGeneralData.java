package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserGeneralData {
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
