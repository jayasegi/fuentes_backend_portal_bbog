package com.portal.api.domain.repository;

import com.portal.api.domain.model.UserEntity;
import java.util.Optional;

public interface UserRepository {
	Optional<UserEntity> findByUsername(String username);
}
