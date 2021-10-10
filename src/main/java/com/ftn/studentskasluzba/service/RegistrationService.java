package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.dto.*;
import com.ftn.studentskasluzba.model.*;
import com.ftn.studentskasluzba.repository.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.UUID;

@Service
public class RegistrationService {

    @Autowired
    RegisterTokenRepository registerTokenRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentsAccountRepository studentsAccountRepository;

    @Value("${registerToken.validityDays:2}")
    Integer registerTokenValidityDays;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserWithRole register(NewUserDTO newUser) throws Exception {
        var tokenOpt = registerTokenRepository.findById(newUser.registerToken());
        if (tokenOpt.isPresent()) {
            var token = tokenOpt.get();
            if (token.getValidUntil().isAfter(DateTime.now())) {
                UserWithRole createdUser = null;
                switch (token.getRole()) {
                    case ADMIN: {
                        var user = new Admin(
                                null,
                                new UserGeneralData(
                                        newUser.email(),
                                        newUser.username(),
                                        passwordEncoder.encode(newUser.password()),
                                        newUser.firstName(),
                                        newUser.lastName()
                                ),
                                false
                        );
                        user = adminRepository.save(user);
                        createdUser = new AdminDTO(user);
                        break;
                    }
                    case STUDENT: {
                        var user = new Student(
                                null,
                                new UserGeneralData(
                                        newUser.email(),
                                        newUser.username(),
                                        passwordEncoder.encode(newUser.password()),
                                        newUser.firstName(),
                                        newUser.lastName()
                                ),
                                null,
                                new HashSet<>(),
                                new HashSet<>(),
                                false
                        );
                        var studentsAccount = new StudentsAccount(
                                null,
                                0d,
                                null,
                                new HashSet<>(),
                                new HashSet<>(),
                                false
                        );
                        studentsAccount = studentsAccountRepository.save(studentsAccount);
                        user.setStudentsAccount(studentsAccount);
                        user = studentRepository.save(user);
                        studentsAccount.setStudent(user);
                        studentsAccount = studentsAccountRepository.save(studentsAccount);
                        user.setStudentsAccount(studentsAccount);
                        createdUser = new StudentDTO(user);
                        break;
                    }
                    case EMPLOYEE: {
                        var user = new Employee(
                                null,
                                new UserGeneralData(
                                        newUser.email(),
                                        newUser.username(),
                                        passwordEncoder.encode(newUser.password()),
                                        newUser.firstName(),
                                        newUser.lastName()
                                ),
                                new HashSet<>(),
                                false
                        );
                        user = employeeRepository.save(user);
                        createdUser = new EmployeeDTO(user);
                        break;
                    }
                }
                if (createdUser != null) {
                    registerTokenRepository.deleteById(newUser.registerToken());
                    return createdUser;
                }
            }
        }
        throw new Exception("Registration failed");
    }

    public RegisterToken generateRegisterToken(Role role) {
        var token = new RegisterToken(UUID.randomUUID().toString(), role, DateTime.now().plusDays(registerTokenValidityDays));
        return registerTokenRepository.save(token);
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void cleanExpiredTokens() {
        System.out.println("Deleting expired register tokens");
        registerTokenRepository.deleteAll(registerTokenRepository.getExpiredTokens());
    }
}
