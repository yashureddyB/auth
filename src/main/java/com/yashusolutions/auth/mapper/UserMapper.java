package com.yashusolutions.auth.mapper;

import org.springframework.stereotype.Component;

import com.yashusolutions.auth.dto.RegisterRequestDto;
import com.yashusolutions.auth.entity.User;

@Component
public class UserMapper {
	public static User toEntity(RegisterRequestDto registerRequestDto) {
		if(registerRequestDto == null) {
			return null;
		} 
		User user = new User();
		user.setUsername(registerRequestDto.getUsername());
		user.setEmail(registerRequestDto.getEmail());
		user.setPassword(registerRequestDto.getPassword());
		return user;
	}
	
}
