package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.dto.Credentials;
import com.ftn.studentskasluzba.model.ApplicationUser;
import com.ftn.studentskasluzba.model.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${jwt.secretKey}")
    private String SECRET_KEY;

    @Value("${jwt.tokenValidityMinutes:5}")
    private Long TOKEN_VALIDITY_MINUTES;

    public String generateToken(ApplicationUser applicationUser) throws Exception {
        var claims = new HashMap<String, Object>();
        claims.put("role", Role.getRole(applicationUser).name());
        claims.put("id", applicationUser.getId());
        claims.put("username", applicationUser.getUserGeneralData().getUsername());
        claims.put("email", applicationUser.getUserGeneralData().getEmail());
        claims.put("firstName", applicationUser.getUserGeneralData().getFirstName());
        claims.put("lastName", applicationUser.getUserGeneralData().getLastName());
        return createToken(claims, applicationUser.getUserGeneralData().getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * TOKEN_VALIDITY_MINUTES))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Role getRole(String token) {
        return Role.valueOf(extractClaim(token, claims -> claims.get("role", String.class)));
    }

    public Long getId(String token) {
        return extractClaim(token, claims -> claims.get("id", Long.class));
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        var claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public Boolean validateToken(String token, ApplicationUser applicationUser) {
        final String username = extractUsername(token);
        return username.equals(applicationUser.getUserGeneralData().getUsername()) && !isTokenExpired(token);
    }
}
