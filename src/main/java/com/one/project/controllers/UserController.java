package com.one.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.project.models.User;
import com.one.project.repository.StudentRepository;
import com.one.project.repository.UserRepository;
import com.one.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	UserService userService;

	@GetMapping("/adduser")
	public String addUser(Model model) {

		return "savestudent";
	}

	@GetMapping("/user")
	public String user(Model model) {

		List<User> listStudents = userService.listStudent();

		model.addAttribute("students", listStudents);

		return "list-students";
	}

	

	@RequestMapping("/update/{email}")
	public String updateUser(@PathVariable String email, Model model,User user) throws Exception {

		User foundUser = userService.updateByEmail(email);

		System.out.println(user);
		
		model.addAttribute("user", foundUser);

		return "update.html";

	}

	@RequestMapping("/delete/{email}")
	public String deleteUser(@PathVariable String email, Model model, User user) throws Exception {

		User foundUser = userService.updateByEmail(user.getEmail());

		userRepository.delete(foundUser);
		
		model.addAttribute("user", user);

		return "redirect:/user";

	}
}