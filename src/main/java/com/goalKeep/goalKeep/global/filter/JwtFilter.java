package com.goalKeep.goalKeep.global.filter;

import com.goalKeep.goalKeep.domain.user.entity.User;
import com.goalKeep.goalKeep.global.provider.JwtProvider;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

public class JwtFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JwtFilter(JwtProvider jwtProvider) {

        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = request.getHeader("accessToken");

        if (accessToken == null) {

            filterChain.doFilter(request, response);

            return;
        }

        try {
            jwtProvider.isExpired(accessToken);
        } catch (ExpiredJwtException e) {

            PrintWriter writer = response.getWriter();
            writer.print("access token expired");

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String category = jwtProvider.getCategory(accessToken);

        if (!category.equals("accessToken")) {

            PrintWriter writer = response.getWriter();
            writer.print("invalid access token");

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String email = jwtProvider.getEmail(accessToken);
        // String role = jwtProvider.getRole(accessToken);

        User user = User.builder()
                .email(email)
                .build();

        // SecurityContextHolder.getContext().setAuthentication();

        filterChain.doFilter(request, response);
    }
}
