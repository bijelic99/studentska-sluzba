package com.ftn.studentskasluzba.model;

import com.ftn.studentskasluzba.model.security.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee extends BaseAbstractClass implements ApplicationUser {
    @Embedded
    private UserGeneralData userGeneralData;
    @OneToMany(mappedBy = "employee")
    private Set<Teacher> teacherPositions = new HashSet<>();

    public Employee(Long id, UserGeneralData userGeneralData, Set<Teacher> teacherPositions) {
        super(id);
        this.userGeneralData = userGeneralData;
        this.teacherPositions = teacherPositions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(
                new CourseAdditionalPointsCreateAndEdit(),
                new CourseAdditionalPointsEnrolmentCreateAndEdit(),
                new CourseCreateAndEdit(),
                new ExamCreateAndEdit(),
                new ExamEnrolmentCreateAndEdit(),
                new TeacherCreate()
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
