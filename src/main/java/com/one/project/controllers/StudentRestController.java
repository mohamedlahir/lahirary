package com.one.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.project.models.Student;
import com.one.project.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import net.minidev.json.JSONObject;

@RestController
public class StudentRestController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/")
	public JSONObject root() {

		JSONObject value = new JSONObject();

		return value.appendField("Students", "Welcome to Students Panel :)");
	};

	@RequestMapping(value = "/savestudent/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student saveStudent(@RequestBody Student students, @PathVariable int id) {

		return studentService.saveStudent(students, id);

	}

	@RequestMapping(value = "/delete-student/{id}", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}

	@PutMapping(value = "/update-student/{id}", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Student update(@PathVariable int id, @RequestBody Student student) {

		return studentService.updateStudent(id, student);
	}

	@RequestMapping("/delete-all-students")
	public String deleteallstudent(HttpServletRequest req) {
		return studentService.deleteAll(req);
	}

	@RequestMapping("/get-one-student/{id}")
	public Student getOne(@PathVariable int id) {
		return studentService.getOne(id);

	}

	@RequestMapping(value = "/setteacher/{teacherID}/{studentID}")
	public Student setteacher(@PathVariable int teacherID, @PathVariable int studentID) {

		return studentService.setTeacher(teacherID, studentID);

	}

}
