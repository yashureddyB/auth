package com.yashusolutions.auth.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yashusolutions.auth.dto.LoginRequestDto;
import com.yashusolutions.auth.dto.RegisterRequestDto;
import com.yashusolutions.auth.entity.User;
import com.yashusolutions.auth.mapper.UserMapper;
import com.yashusolutions.auth.repository.UserRepository;
import com.yashusolutions.auth.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	private final PasswordEncoder encoder;
	private final UserRepository repository;

	public AuthServiceImpl(PasswordEncoder encoder, UserRepository repository) {
		super();
		this.encoder = encoder;
		this.repository = repository;
	}

	@Override
	public void registerRequest(RegisterRequestDto requestDto) {
		User user = UserMapper.toEntity(requestDto);
		user.setPassword(encoder.encode(user.getPassword()));
		repository.save(user);

	}

	@Override
	public boolean login(LoginRequestDto loginRequestDto) {

		return repository.findByEmail(loginRequestDto.getEmail())
				.map(user -> encoder.matches(loginRequestDto.getPassword(), user.getPassword())).orElse(false);
	}

}
