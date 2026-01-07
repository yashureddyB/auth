package com.yashu.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashu.auth.entity.AuthEntity;

public interface AuthRepository extends JpaRepository<AuthEntity, Long>{
	public <AuthEntity> void findByEmail(String email);

}
