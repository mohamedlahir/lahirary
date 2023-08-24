package com.one.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.one.project.models.LoginDto;
import com.one.project.models.RegisterDto;
import com.one.project.models.Role;
import com.one.project.models.User;
import com.one.project.repository.UserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	UserRepository userRepository;

	public void saveStudent(User user) {

		userRepository.save(user);

	}

	public List<User> listStudent() {

		return userRepository.findAll();

	}

	public User updateByEmail(String email) {

		return userRepository.findByEmail(email);
		
	}

	@Override
	public String authenticate(LoginDto loginDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> register(RegisterDto registerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saverUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
