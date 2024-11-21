package org.pgm.shopserver.security.jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.pgm.shopserver.security.UserPrinciple;
import org.springframework.security.core.Authentication;

public interface JwtProvider {
    String generateToken(UserPrinciple auth);
    Authentication getAuthentication(HttpServletRequest request);
    boolean isTokenValid(HttpServletRequest request);
}
