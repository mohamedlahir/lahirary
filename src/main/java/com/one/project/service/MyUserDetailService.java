package com.one.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.one.project.repository.UserRepository;

public class MyUserDetailService {

	
	//	implements UserDetailsService 
	
	
	@Autowired
	UserRepository userRepository;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByuserName(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found");
//		}
//		return new MyUserPrincipal(user);
//	}

}
