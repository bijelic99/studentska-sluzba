package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin extends BaseAbstractClass implements ApplicationUser {
    @Embedded
    private UserGeneralData userGeneralData;
}
