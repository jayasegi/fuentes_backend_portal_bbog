package com.portal.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCoursesResponseDto {
	@JsonProperty ("idCursoUsuario")
	private Long idCursoUsuario;
	
	@JsonProperty ("idCurso")
	private Long idCurso;
	
	@JsonProperty ("nombreCurso")
	private String nombreCurso;
	
	@JsonProperty ("idModulo")
	private Long idModulo;
	
	@JsonProperty ("nombreModulo")
	private String nombreModulo;
	
	@JsonProperty ("estado")
	private String estado;
	
	@JsonProperty ("fechaEstado")
	private String fechaEstado;
}
