package com.ftn.studentskasluzba.model;

import com.ftn.studentskasluzba.model.security.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Admin extends BaseAbstractClass implements ApplicationUser {
    @Embedded
    private UserGeneralData userGeneralData;

    public Admin(Long id, UserGeneralData userGeneralData, Boolean deleted) {
        super(id, deleted);
        this.userGeneralData = userGeneralData;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(
                new CourseAdditionalPointsCreateAndEdit(),
                new CourseAdditionalPointsEnrolmentCreateAndEdit(),
                new CourseCreateAndEdit(),
                new ExamCreateAndEdit(),
                new ExamEnrolmentCreateAndEdit(),
                new TeacherCreate(),
                new TeacherDelete(),
                new ExamPeriodCreateAndEdit()
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
