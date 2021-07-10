package com.ftn.studentskasluzba.repository;

import com.ftn.studentskasluzba.model.RegisterToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RegisterTokenRepository extends JpaRepository<RegisterToken, String> {
    @Query(
            value = "SELECT * FROM REGISTER_TOKEN WHERE valid_until < NOW()",
            nativeQuery = true
    )
    Collection<RegisterToken> getExpiredTokens();
}
