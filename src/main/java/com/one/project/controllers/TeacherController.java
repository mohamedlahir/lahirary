package com.one.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.project.models.TeacherModel;
import com.one.project.repository.TeacherRepository;
import com.one.project.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	TeacherService teacherService;

	@RequestMapping("/saveteacher")
	public TeacherModel saveTeacher(@RequestBody TeacherModel teacher) {

		return teacherService.saveTeacher(teacher);

	}

}
