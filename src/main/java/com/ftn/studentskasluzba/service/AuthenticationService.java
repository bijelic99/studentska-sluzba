package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.dto.*;
import com.ftn.studentskasluzba.model.*;
import com.ftn.studentskasluzba.repository.RefreshTokenRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    JwtService jwtService;


    @Value("${refreshToken.validityDays:2}")
    Integer refreshTokenValidityDays;

    public UserWithTokens login(Credentials credentials) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password())
        );

        var user = (ApplicationUser) userDetailsService.loadUserByUsername(credentials.username());
        var token = jwtService.generateToken(user);
        var refreshToken = UUID.randomUUID().toString();
        putRefreshToken(refreshToken, token);
        if (user instanceof Student) {
            return new UserWithTokens(new StudentDTO((Student) user), token, refreshToken);
        } else if (user instanceof Employee) {
            return new UserWithTokens(new EmployeeDTO((Employee) user), token, refreshToken);
        } else if (user instanceof Admin) {
            return new UserWithTokens(new AdminDTO((Admin) user), token, refreshToken);
        } else throw new Exception("Cannot return user");
    }

    public void logout(Tokens tokens) throws Exception {
        var dbEntry = refreshTokenRepository.findById(tokens.refreshToken()).orElseThrow();
        if (jwtService.isTokenExpired(tokens.jwtToken()) && dbEntry.getCurrentJwtToken().equals(tokens.jwtToken())) {
            refreshTokenRepository.deleteById(tokens.refreshToken());
        } else throw new Exception("Cannot logout, jwt token invalid");
    }

    public String refresh(Tokens tokens) throws Exception {
        var dbEntry = refreshTokenRepository.findById(tokens.refreshToken()).orElseThrow();
        if (jwtService.isTokenExpired(tokens.jwtToken()) && dbEntry.getCurrentJwtToken().equals(tokens.jwtToken())) {
            var username = jwtService.extractUsername(tokens.jwtToken());
            var user = (ApplicationUser) userDetailsService.loadUserByUsername(username);
            var newToken = jwtService.generateToken(user);
            dbEntry.setCurrentJwtToken(newToken);
            refreshTokenRepository.save(dbEntry);
            return newToken;
        } else throw new Exception("Cannot refresh, jwt token invalid");
    }

    private void putRefreshToken(String refreshToken, String jwtToken) {
        var savedToken = refreshTokenRepository
                .findById(refreshToken)
                .map(rt -> {
                    rt.setCurrentJwtToken(jwtToken);
                    return rt;
                })
                .orElse(new RefreshToken(refreshToken, jwtToken, DateTime.now().plusDays(refreshTokenValidityDays)));
        refreshTokenRepository.save(savedToken);
    }

    //@Scheduled(cron = "0 0 0/1 * * ?")
    @Scheduled(cron = "0 0/1 * * * ?")
    public void cleanExpiredTokens() {
        var expiredTokens = refreshTokenRepository.getExpiredTokens();
        System.out.println("Deleting " + expiredTokens.size() + " expired tokens" );
        refreshTokenRepository.deleteAll(expiredTokens);
    }
}
