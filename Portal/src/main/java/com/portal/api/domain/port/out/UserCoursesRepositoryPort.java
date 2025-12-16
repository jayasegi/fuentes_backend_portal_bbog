package com.portal.api.domain.port.out;

import java.util.Optional;

import com.portal.api.domain.model.UserCoursesEntity;

public interface UserCoursesRepositoryPort {
	Optional<UserCoursesEntity> findById(Long id);
	UserCoursesEntity save(UserCoursesEntity userCourses);
}
