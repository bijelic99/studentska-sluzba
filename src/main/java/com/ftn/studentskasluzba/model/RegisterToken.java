package com.ftn.studentskasluzba.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class RegisterToken {
    @Id
    @Column(name = "token", unique = true, nullable = false)
    String token;
    @Enumerated(EnumType.STRING)
    Role role;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime validUntil;

    private RegisterToken() {
    }

    public RegisterToken(String token, Role role, DateTime validUntil) {
        this.token = token;
        this.role = role;
        this.validUntil = validUntil;
    }
}
