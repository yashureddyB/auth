package com.yashusolutions.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yashusolutions.auth.dto.ApiResponseDto;
import com.yashusolutions.auth.dto.LoginRequestDto;
import com.yashusolutions.auth.dto.RegisterRequestDto;
import com.yashusolutions.auth.service.impl.AuthServiceImpl;

@RestController
@RequestMapping("/api/auth")
public class UserController {
	private final AuthServiceImpl service;

	public UserController(AuthServiceImpl service) {
		super();
		this.service = service;
	}
 @PostMapping("/register")
	public ResponseEntity<ApiResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
		service.registerRequest(registerRequestDto);

		return ResponseEntity.ok(new ApiResponseDto("registered sucessfull"));

	}
 @GetMapping("/login")
 	public ResponseEntity<ApiResponseDto>login(@RequestBody LoginRequestDto loginRequestDto){
 		boolean success=service.login(loginRequestDto);
 		return success
 			    ? ResponseEntity.ok(new ApiResponseDto("LOGIN_SUCCESS"))
 			    : ResponseEntity.status(401)
 			        .body(new ApiResponseDto("INVALID_CREDENTIALS"));
 	}

}
