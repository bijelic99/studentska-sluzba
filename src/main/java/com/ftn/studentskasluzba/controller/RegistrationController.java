package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.NewUserDTO;
import com.ftn.studentskasluzba.dto.UserWithRole;
import com.ftn.studentskasluzba.model.RegisterToken;
import com.ftn.studentskasluzba.model.Role;
import com.ftn.studentskasluzba.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<UserWithRole> register(@RequestBody NewUserDTO newUser) {
        try {
            return ResponseEntity.ok(registrationService.register(newUser));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/api/{role}/generate/register-token")
    @PreAuthorize("hasAuthority('UserRegisterTokenGenerate')")
    public RegisterToken generateRegisterToken(@PathVariable("role") Role role) {
        return registrationService.generateRegisterToken(role);
    }
}
