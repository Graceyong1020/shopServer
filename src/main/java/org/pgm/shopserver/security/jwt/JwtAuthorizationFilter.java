package org.pgm.shopserver.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication authentication = jwtProvider.getAuthentication(request); // 토큰을 통해 인증 정보를 가져옴

        if(authentication != null && jwtProvider.isTokenValid(request)) { // 토큰이 유효하면
            SecurityContextHolder.getContext().setAuthentication(authentication); // 인증 정보를 SecurityContextHolder에 저장
        }
        filterChain.doFilter(request, response); // 다음 필터로 넘어감

    }
}
