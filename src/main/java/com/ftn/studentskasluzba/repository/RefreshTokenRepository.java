package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
    @Query(
            value = "SELECT * FROM refresh_token WHERE expire_time < NOW()",
            nativeQuery = true
    )
    Collection<RefreshToken> getExpiredTokens();
}
