package com.portal.api.adapters.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.api.application.service.UserQueryService;
import com.portal.api.domain.dto.UserDto;
import com.portal.api.domain.dto.UserRequest;
import com.portal.api.domain.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserQueryService userQueryService;

    /**
     * Método POST que busca un usuario por username.
     * Solo accesible para ROLE_USER.
     */
    @PostMapping("/find")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserDto> findUser(@RequestBody UserRequest request) {
    	ObjectMapper objectMapper = new ObjectMapper();
    	UserDto userDto = new UserDto();
        UserEntity user = userQueryService.findByUsername(request.getUsername());
        String data = "";
        
        try {
        	data = objectMapper.writeValueAsString(user);
        	userDto = objectMapper.readValue(data, UserDto.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResponseEntity.ok(userDto);
    }
}
