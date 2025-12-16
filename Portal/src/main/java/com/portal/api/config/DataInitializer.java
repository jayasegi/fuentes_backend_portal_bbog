package com.portal.api.config;

import com.portal.api.adapters.out.persistence.SpringDataUserRepository;
import com.portal.api.domain.model.UserEntity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

	@Bean
	CommandLineRunner initUsers(SpringDataUserRepository repo, PasswordEncoder encoder) {
		return args -> {
			if (repo.findByUsername("user1").isEmpty()) {
				UserEntity u = new UserEntity("user1", encoder.encode("password"), "ROLE_USER");
				repo.save(u);
				System.out.println("Usuario inicial creado: user1 / password");
			}
		};
	}
}
