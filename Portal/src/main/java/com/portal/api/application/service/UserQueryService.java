package com.portal.api.application.service;

import com.portal.api.domain.model.UserEntity;
import com.portal.api.domain.repository.UserRepository;
import com.portal.api.exceptions.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserQueryService {

	@Autowired
	private UserRepository userRepository;

	public UserEntity findByUsername(String username) {
		return userRepository.findByUsername(username)
		.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND.toString(), "Usuario no encontrado.", HttpStatus.NOT_FOUND.value()));
		//.orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
	}
}
