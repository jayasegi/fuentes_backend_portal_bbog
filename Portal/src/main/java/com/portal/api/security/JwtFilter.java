package com.portal.api.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.portal.api.exceptions.CustomException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	public JwtFilter(JwtUtil jwtUtil){
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException { //, CustomException, RuntimeException
		String authHeader = request.getHeader("Authorization");
		if (! request.getRequestURI().equals("/api/auth/login")) {
			if (authHeader != null && authHeader.startsWith("Bearer ")) {
				String token = authHeader.substring(7);
				try {
					var claims = jwtUtil.validateToken(token).getBody();
					String username = claims.getSubject();
					String role = claims.get("role", String.class);
					var auth = new UsernamePasswordAuthenticationToken(
							username,
							null,
							List.of(new SimpleGrantedAuthority(role))
							);
					SecurityContextHolder.getContext().setAuthentication(auth);
				} catch (Exception e) {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
					//throw new CustomException("0", "Token inválido: " + e.getMessage(), 0);
					return;
				}
			}
		}
		filterChain.doFilter(request, response);
	}
}
