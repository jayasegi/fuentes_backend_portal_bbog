package com.portal.api.adapters.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portal.api.application.service.UserCoursesQueryService;
import com.portal.api.domain.dto.UserCoursesResponseDto;
import com.portal.api.domain.dto.UserRequest;
import com.portal.api.domain.model.UserCoursesEntity;
import com.portal.api.exceptions.CustomException;
import com.portal.api.util.Functions;

@RestController
@RequestMapping("/api/user_courses")
public class UserCoursesController {

    @Autowired
    private UserCoursesQueryService userCoursesQueryService;

    /**
     * Método POST que busca los cursos relacionados a un usuario por id.
     * Solo accesible para ROLE_USER.
     */
    @PostMapping("/courses")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<UserCoursesResponseDto>> findUserCourses(@RequestBody UserRequest request) {
    	List<UserCoursesResponseDto> userCoursesResonse = new ArrayList<>();
    	Functions functions = new Functions();
    	//ObjectMapper objectMapper = new ObjectMapper();
    	//List<UserCoursesEntity> userCourses = userCoursesQueryService.findByUserId(request.getId());
    	List<UserCoursesEntity> userCourses = userCoursesQueryService.findByUser_Username(request.getUsername());
        
        try {
        	//String data = objectMapper.writeValueAsString(userCourses);
        	//userCoursesDto = objectMapper.readValue(data, new TypeReference<ArrayList<UserCoursesResponseDto>>() {});
        	userCoursesResonse = functions.convertToUserCoursesResponse(userCourses);
		} catch (Exception e) {
			//e.printStackTrace();
			throw new CustomException(HttpStatus.NOT_FOUND.toString(), "user_courses: " + e.getMessage(), HttpStatus.NOT_FOUND.value());
		} finally {
			
		}
        return ResponseEntity.ok(userCoursesResonse);
    }
}
