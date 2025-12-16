package com.portal.api.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portal.api.domain.model.UserCoursesEntity;
import com.portal.api.domain.repository.UserCoursesRepository;

@Service
public class UserCoursesQueryService {

	@Autowired
	private UserCoursesRepository userRepository;

	public List<UserCoursesEntity> findByUserId(Long id) {	
		return userRepository.findByUserId(id);
		//.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND.toString(), "Cursos relacionados al usuario, no encontrados.", HttpStatus.NOT_FOUND.value()));
	}
	
	public List<UserCoursesEntity> findByUser_Username(String userName) {	
		return userRepository.findByUser_Username(userName);
	}
}
