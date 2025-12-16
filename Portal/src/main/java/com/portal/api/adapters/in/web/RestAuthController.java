package com.portal.api.adapters.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.api.domain.dto.LoginRequest;
import com.portal.api.domain.dto.LoginResponse;
import com.portal.api.domain.port.in.LoginUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class RestAuthController {
	
	private final LoginUseCase loginUseCase;
	public RestAuthController(LoginUseCase loginUseCase){
		this.loginUseCase = loginUseCase;
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest req){
		//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		System.out.println("Login: "); // + encoder.encode("password"));
		String token = loginUseCase.login(req.getUsername(), req.getPassword());
		System.out.println("Token: " + token);
		return ResponseEntity.ok(new LoginResponse(token, "Bearer"));
	}
}
