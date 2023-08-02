package com.one.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.one.project.models.ParentModel;
import com.one.project.models.Student;
import com.one.project.models.TeacherModel;
import com.one.project.models.User;
import com.one.project.repository.ParentRepository;
import com.one.project.repository.PostRepository;
import com.one.project.repository.StudentRepository;
import com.one.project.repository.TeacherRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class StudentService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ParentRepository parentRepo;

	@Autowired
	TeacherRepository teacherRepo;

	int loop = 0;

	public Student saveStudent(Student students, int id) {

		ParentModel parent = new ParentModel();

		Faker faker = new Faker();

		String name = faker.name().fullName();

		students.setName(name);

		Optional<ParentModel> parentId = parentRepo.findById(id);

		parent.setParentID(parentId.get().getParentID());

		parent.setFatherName(parentId.get().getFatherName());

		parent.setMotherName(parentId.get().getMotherName());

		parentRepo.save(parent);

		students.setParent(parent);

		studentRepository.save(students);

		return students;
	}

	public String deleteStudent(int id) {

		studentRepository.deleteById(id);

		return "Deleted";
	}

	public Student updateStudent(int id, Student student) {

		System.out.println("Student ID : " + id);

		Student studentData = studentRepository.getById(id);

		String name = student.getName();

		String section = student.getSection();

		String grade = student.getGrade();

		int rollnum = student.getRollnum();

		studentData.setGrade(grade);

		studentData.setName(name);

		studentData.setRollnum(rollnum);

		studentData.setSection(section);

		studentRepository.save(studentData);

		return student;
	}

	public String deleteAll(HttpServletRequest request) {

		String requestIP = request.getRemoteAddr();

		System.out.println(requestIP);

		studentRepository.deleteAll();

		return "ALL Records Deleted, Deleted By " + requestIP;
	}

	public Student getOne(int id) {

		Student student = studentRepository.findById(id).get();

		return student;

	}

	public Student setTeacher(int teacherID, int studentID) {

		TeacherModel teacher = teacherRepo.findById(teacherID).get();

		Student student = studentRepository.findById(studentID).get();

		List<TeacherModel> teacher1 = new ArrayList<>();

		teacher1.add(teacher);

		student.setTeacher(teacher1);

		studentRepository.save(student);

		return student;
	}

	public List<Student> listStudent() {

		return studentRepository.findAll();
	}

	public List<Student> findByKeyword(String keyword) {

		return studentRepository.findByKeyWord(keyword);
	}

	public long count() {

		return studentRepository.count();
	}

}
