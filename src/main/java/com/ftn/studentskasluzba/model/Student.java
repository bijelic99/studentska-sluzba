package com.ftn.studentskasluzba.model;

import com.ftn.studentskasluzba.model.security.CourseAdditionalPointsEnrolmentCreateAndEdit;
import com.ftn.studentskasluzba.model.security.ExamEnrolmentCreateAndEdit;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student extends BaseAbstractClass implements ApplicationUser{
    @Embedded
    private UserGeneralData userGeneralData;
    @OneToOne(mappedBy = "student")
    private StudentsAccount studentsAccount;
    @OneToMany(mappedBy = "student")
    private Set<StudentsDocument> studentsDocuments = new HashSet<>();
    @OneToMany(mappedBy = "student")
    private Set<CourseEnrolment> courseEnrolments = new HashSet<>();

    public Student(Long id, UserGeneralData userGeneralData, StudentsAccount studentsAccount, Set<StudentsDocument> studentsDocuments, Set<CourseEnrolment> courseEnrolments) {
        super(id);
        this.userGeneralData = userGeneralData;
        this.studentsAccount = studentsAccount;
        this.studentsDocuments = studentsDocuments;
        this.courseEnrolments = courseEnrolments;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(
                new CourseAdditionalPointsEnrolmentCreateAndEdit(),
                new ExamEnrolmentCreateAndEdit()
        );
    }

    @Override
    public String getPassword() {
        return userGeneralData.getPassword();
    }

    @Override
    public String getUsername() {
        return userGeneralData.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
