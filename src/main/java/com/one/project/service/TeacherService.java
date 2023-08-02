package com.one.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.one.project.models.TeacherModel;
import com.one.project.repository.StudentRepository;
import com.one.project.repository.TeacherRepository;
import com.one.project.utils.RandomIDGenerator;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepo;

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	RandomIDGenerator idGenerator;

	public TeacherModel saveTeacher(TeacherModel teacher) {

		teacher.setTeacherID(idGenerator.numberGenerator());

		teacherRepo.save(teacher);

		return teacher;
	}

}