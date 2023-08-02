package com.one.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.one.project.models.ParentModel;
import com.one.project.repository.ParentRepository;
import com.one.project.repository.StudentRepository;

@Service
public class ParentService {

	@Autowired
	ParentRepository parentRepo;

	@Autowired
	StudentRepository studentRepo;

	public List<ParentModel> getParent() {

		List<ParentModel> parent = parentRepo.findAll();

		return parent;
	}

	public ParentModel save(ParentModel parent) {

		Faker faker = new Faker();

		String fatherName = faker.name().fullName();
		
		String motherName = faker.name().firstName();
		
		parent.setFatherName(fatherName);
		
		parent.setMotherName(motherName);

		parentRepo.save(parent);

		return parent;
	}

}
