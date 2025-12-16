package com.portal.api.adapters.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.api.domain.model.UserCoursesEntity;
import com.portal.api.domain.model.UserEntity;

public interface SpringDataUserCoursesRepository extends JpaRepository<UserCoursesEntity, Long> {
	//Optional<UserCoursesEntity> findByUserId(Long id);
	List<UserCoursesEntity> findByUser_Id(Long userId);
	List<UserCoursesEntity> findByUserId(UserEntity user);
	List<UserCoursesEntity> findByUser_Username(String userName);
}
