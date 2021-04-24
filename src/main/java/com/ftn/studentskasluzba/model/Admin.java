package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Admin extends BaseAbstractClass implements ApplicationUser {
    @Embedded
    private UserGeneralData userGeneralData;
}
