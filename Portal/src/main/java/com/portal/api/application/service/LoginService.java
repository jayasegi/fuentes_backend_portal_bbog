package com.portal.api.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portal.api.domain.model.UserEntity;
import com.portal.api.domain.port.in.LoginUseCase;
import com.portal.api.domain.port.out.UserRepositoryPort;
import com.portal.api.exceptions.CustomException;
import com.portal.api.security.JwtUtil;

@Service
public class LoginService implements LoginUseCase {

	private final UserRepositoryPort userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	public LoginService(UserRepositoryPort userRepository,
		PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public String login(String username, String password) {
		UserEntity user = userRepository.findByUsername(username)
			.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND.toString(), "Usuario no encontrado.", HttpStatus.NOT_FOUND.value()));
			//.orElseThrow(() -> new RuntimeException("Usuario no encontrado."));

		System.out.println("username: " + username);

		if (!passwordEncoder.matches(password, user.getPasswordHash())) {
			throw new RuntimeException("Credenciales inválidas.");
		}

		return jwtUtil.generateToken(user.getUsername(), user.getRole());
	}
}
