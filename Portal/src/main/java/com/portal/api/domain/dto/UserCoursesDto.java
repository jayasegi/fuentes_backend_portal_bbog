package com.portal.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.portal.api.domain.model.CursosEntity;
import com.portal.api.domain.model.UserEntity;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCoursesDto {	
	
	@JsonProperty("idCursoUsuario")
    private Long idCursoUsuario;
    
	@JsonProperty("usuario")
    private UserDto usuario;
    
	@JsonProperty("curso")
    private CursosEntity curso; //
    
	@JsonProperty("estado")
    private String estado;

	@JsonProperty("fechaEstado")
    private String fechaEstado;
}