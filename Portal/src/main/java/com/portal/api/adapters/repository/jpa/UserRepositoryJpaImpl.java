package com.portal.api.adapters.repository.jpa;

import com.portal.api.adapters.out.persistence.SpringDataUserRepository;
import com.portal.api.domain.model.UserEntity;
import com.portal.api.domain.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryJpaImpl implements UserRepository {

    @Autowired
    private SpringDataUserRepository repo;

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return repo.findByUsername(username);
    }
}
