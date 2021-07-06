package com.ftn.studentskasluzba.model;

import com.ftn.studentskasluzba.model.security.AllGranted;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Embeddable;
import java.util.Arrays;
import java.util.Collection;

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
