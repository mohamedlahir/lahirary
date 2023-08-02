package com.one.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.project.models.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByEmail(String email);

	User findByuserName(String userName);

}
