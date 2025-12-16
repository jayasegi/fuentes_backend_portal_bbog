package com.portal.api.domain.port.out;

import java.util.Optional;

import com.portal.api.domain.model.UserEntity;

public interface UserRepositoryPort {
	Optional<UserEntity> findByUsername(String username);
	UserEntity save(UserEntity user);
}
