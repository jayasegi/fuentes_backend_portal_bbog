package com.portal.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
	@JsonProperty("token")
	public String token;

	@JsonProperty("tokenType")
	public String tokenType;
}
