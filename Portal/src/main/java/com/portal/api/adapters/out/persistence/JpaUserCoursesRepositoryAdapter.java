package com.portal.api.adapters.out.persistence;

import java.util.Optional;
import org.springframework.stereotype.Component;
import com.portal.api.domain.model.UserCoursesEntity;
import com.portal.api.domain.port.out.UserCoursesRepositoryPort;

@Component
public class JpaUserCoursesRepositoryAdapter implements UserCoursesRepositoryPort {

	private final SpringDataUserCoursesRepository repo;

	public JpaUserCoursesRepositoryAdapter(SpringDataUserCoursesRepository repo){
		this.repo = repo;
	}
	
	@Override
	public Optional<UserCoursesEntity> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public UserCoursesEntity save(UserCoursesEntity userCourses) {
		return repo.save(userCourses);
	}
}
