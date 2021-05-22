package com.ftn.studentskasluzba.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Admin extends BaseAbstractClass implements ApplicationUser {
    @Embedded
    private UserGeneralData userGeneralData;

    public Admin(Long id, UserGeneralData userGeneralData) {
        super(id);
        this.userGeneralData = userGeneralData;
    }
}
