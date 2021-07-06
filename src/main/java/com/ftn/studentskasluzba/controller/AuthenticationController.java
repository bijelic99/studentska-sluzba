package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.Credentials;
import com.ftn.studentskasluzba.dto.Tokens;
import com.ftn.studentskasluzba.dto.UserWithTokens;
import com.ftn.studentskasluzba.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<UserWithTokens> login(@RequestBody Credentials credentials) {
        try {
            return ResponseEntity.ok(authenticationService.login(credentials));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody Tokens tokens) {
        return null;
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refresh(@RequestBody Tokens tokens) {
        return null;
    }
}
