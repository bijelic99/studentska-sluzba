package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class RefreshToken {

    @Id
    @Column(name = "refreshToken", unique = true, nullable = false)
    private String refreshToken;
    @Column(name = "currentJwtToken", nullable = false)
    private String currentJwtToken;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime expireTime;

    private RefreshToken() {
    }
}
