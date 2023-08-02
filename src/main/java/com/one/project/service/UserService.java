package com.one.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.project.models.User;
import com.one.project.repository.UserRepository;

@Service
public class UserService {

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

}
