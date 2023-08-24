package com.one.project.service;

import org.springframework.http.ResponseEntity;

import com.one.project.models.LoginDto;
import com.one.project.models.RegisterDto;
import com.one.project.models.Role;
import com.one.project.models.User;

public interface IUserService {

	  String authenticate(LoginDto loginDto);
	   ResponseEntity<?> register (RegisterDto registerDto);
	   Role saveRole(Role role);

	   User saverUser (User user) ;
	
}
