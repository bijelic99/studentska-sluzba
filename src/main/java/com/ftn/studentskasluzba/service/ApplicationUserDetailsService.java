package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.repository.AdminRepository;
import com.ftn.studentskasluzba.repository.EmployeeRepository;
import com.ftn.studentskasluzba.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return studentRepository.findByUsername(s)
                .or(() -> employeeRepository.findByUsername(s))
                .or(() -> adminRepository.findByUsername(s))
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }
}
