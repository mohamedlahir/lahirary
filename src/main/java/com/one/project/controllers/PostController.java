package com.one.project.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.project.models.PostModel;
import com.one.project.repository.PostRepository;
import com.one.project.service.PostService;
import com.one.project.service.StudentService;

import net.minidev.json.JSONObject;

@RestController
public class PostController {

	@Autowired
	StudentService studentService;

	@Autowired
	PostRepository postRepo;

	@Autowired
	PostService postService;

	@RequestMapping("/studentpostcontroller")
	public JSONObject hello() {

		JSONObject json = new JSONObject();

		return json.appendField("Message", "Welcome to Post Module :) ");
	}

	@RequestMapping(value = "/save-post/{id}")
	public PostModel savePost(@RequestBody PostModel postModel, @PathVariable int id) {

//		return studentService.setPost(id);

		return postService.save(postModel, id);

	}

	@RequestMapping(value = "/get-all-post")
	public List<PostModel> getAll() {
		return postService.getAllPost();
	}

	@RequestMapping(value = "/get-all-post-by-student/{studentId}")
	public List<PostModel> getOnePostByStudent(@PathVariable int studentId) throws IOException {

		return postService.getOnePostByStudent(studentId);

	}

	@GetMapping("/he")
	public void he() {

		System.out.println();
		
		postRepo.findAll().forEach(System.out::println);
	}
}
