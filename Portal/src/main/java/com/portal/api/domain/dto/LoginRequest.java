package com.portal.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
	@NotBlank
	@JsonProperty("username")
	public String username;

	@NotBlank
	@JsonProperty("password")
	public String password;
}
