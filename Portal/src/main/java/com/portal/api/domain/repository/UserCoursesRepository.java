package com.portal.api.domain.repository;

import java.util.List;

import com.portal.api.domain.model.UserCoursesEntity;

public interface UserCoursesRepository {
	List<UserCoursesEntity> findByUserId(Long id);
	List<UserCoursesEntity> findByUser_Username(String userName);
}
