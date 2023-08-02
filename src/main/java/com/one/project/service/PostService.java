package com.one.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.project.models.PostModel;
import com.one.project.models.Student;
import com.one.project.repository.PostRepository;
import com.one.project.repository.StudentRepository;
import com.one.project.utils.RandomIDGenerator;

@Service
public class PostService {

	@Autowired
	PostRepository postRepo;

	@Autowired
	StudentRepository studentRepo;

	public PostModel save(PostModel postModel, int id) {

		Student student = new Student();

		student = studentRepo.findById(id).get();

		System.out.println("ID : " + id);

		RandomIDGenerator idGenerator = new RandomIDGenerator();

		int postID = idGenerator.numberGenerator();

		postModel.setPost_Id(postID);

		postModel.setStudents(student);

		postRepo.save(postModel);

		return postModel;
	}

	public List<PostModel> getAllPost() {

		List<PostModel> postModel1 = postRepo.findAll();

		return postModel1;

	}

	public List<PostModel> getOnePostByStudent(int id) {

		List<PostModel> postedData = postRepo.findAllDataPostedByStudent(id);

		return postedData;

	}

}