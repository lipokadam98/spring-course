package com.lipokadam.springsecurityclient.repository;

import com.lipokadam.springsecurityclient.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository  extends JpaRepository<VerificationToken,Long> {
    VerificationToken getVerificationTokenByToken(String token);
}
