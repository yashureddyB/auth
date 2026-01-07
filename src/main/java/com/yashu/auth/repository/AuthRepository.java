package com.yashu.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashu.auth.entity.AuthEntity;

public interface AuthRepository extends JpaRepository<AuthEntity, Long>{
	Optional <AuthEntity> findByEmail(String email);
	
}
