package com.portal.api.adapters.out.persistence;

import com.portal.api.domain.model.UserEntity;
import com.portal.api.domain.port.out.UserRepositoryPort;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

	private final SpringDataUserRepository repo;

	public JpaUserRepositoryAdapter(SpringDataUserRepository repo){
		this.repo = repo;
	}

	@Override
	public Optional<UserEntity> findByUsername(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public UserEntity save(UserEntity user) {
		return repo.save(user);
	}
}
