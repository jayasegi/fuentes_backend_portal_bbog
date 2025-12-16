package com.portal.api.adapters.repository.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.portal.api.adapters.out.persistence.SpringDataUserCoursesRepository;
import com.portal.api.domain.model.UserCoursesEntity;
import com.portal.api.domain.repository.UserCoursesRepository;

@Repository
public class UserCoursesRepositoryJpaImpl implements UserCoursesRepository {

    @Autowired
    private SpringDataUserCoursesRepository repo;
    
	@Override
	public List<UserCoursesEntity> findByUserId(Long id) {
		return repo.findByUser_Id(id);
	}

	@Override
	public List<UserCoursesEntity> findByUser_Username(String userName) {
		return repo.findByUser_Username(userName);
	}
}
