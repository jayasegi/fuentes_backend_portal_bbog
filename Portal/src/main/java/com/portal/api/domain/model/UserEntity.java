package com.portal.api.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "id")
	private Long id;

	@Column(unique = true, nullable = false, name = "username")
	private String username;

	@Column(nullable = false, name = "password_hash")
	private String passwordHash;

	@Column(nullable = false)
	private String role;

	public UserEntity() {}

	public UserEntity(String username, String passwordHash, String role) {
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPasswordHash() { return passwordHash; }
	public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

	public String getRole() { return role; }
	public void setRole(String role) { this.role = role; }
}
