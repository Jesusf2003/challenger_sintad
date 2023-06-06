package com.auth.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDTO {

	private String user;
	private String pwd;
	private String token;
}