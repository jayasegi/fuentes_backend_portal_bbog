package com.portal.api.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.api.domain.dto.UserCoursesResponseDto;
import com.portal.api.domain.model.UserCoursesEntity;

public class Functions {
	public Functions () {}
	
	public List<UserCoursesResponseDto> convertToUserCoursesResponse (List<UserCoursesEntity> userCourses) {
		List<UserCoursesResponseDto> userCoursesResponse = new ArrayList<>();
		UserCoursesResponseDto userCoursesDto = new UserCoursesResponseDto();
		
    	for (UserCoursesEntity userCourse: userCourses) {
    		userCoursesDto = new UserCoursesResponseDto();
    		
    		userCoursesDto.setIdCursoUsuario(userCourse.getIdCursoUsuario());
    		userCoursesDto.setIdCurso(userCourse.getCurso().getIdCurso());
    		userCoursesDto.setIdModulo(userCourse.getCurso().getModulo().getIdModulo());
    		userCoursesDto.setNombreCurso(userCourse.getCurso().getNombreCurso());
    		userCoursesDto.setNombreModulo(userCourse.getCurso().getModulo().getNombreModulo());
    		userCoursesDto.setFechaEstado(userCourse.getFechaEstado());
    		userCoursesDto.setEstado(userCourse.getEstado());
    		userCoursesResponse.add(userCoursesDto);
    	}

		return userCoursesResponse;
		
	}
}
