package com.yashusolutions.auth.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RegisterRequestDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private String password;

}
