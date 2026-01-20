package com.yashusolutions.auth.service;

import com.yashusolutions.auth.dto.LoginRequestDto;
import com.yashusolutions.auth.dto.RegisterRequestDto;

public interface AuthService {
	public void registerRequest(RegisterRequestDto requestDto);
	public boolean login(LoginRequestDto loginRequestDto);
}
