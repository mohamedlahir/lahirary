package com.one.project.MVController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.one.project.models.Student;
import com.one.project.models.TeacherModel;
import com.one.project.repository.StudentRepository;
import com.one.project.service.StudentService;

//@EnableWebSecurity
@Controller
public class StudentViewController {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentService studentService;

	@GetMapping("/students-home")
	public String studentHome(Model model, @RequestParam(value = "keyword", required = false) String keyword) {

		System.out.println("Keyword : " + keyword);

		if (keyword != null) {
			model.addAttribute("students", studentService.findByKeyword(keyword));
			model.addAttribute("count", studentService.count());
			System.out.println("Keyword Seacrh : " + studentService.findByKeyword(keyword));
		} else {
			model.addAttribute("count", studentService.count());
			model.addAttribute("students", studentService.listStudent());
		}

		return "list-students";

	}

	@GetMapping("/register")
	public String showForm(Model model) {

		Student user = new Student();

		model.addAttribute("student", user);

		return "savestudent";
	}

	@PostMapping("/register")
	public String submitForm(@ModelAttribute("student") Student students, Model model) throws Exception {

		System.out.println(students);

		students.setRollnum(students.getRollnum());

		studentRepository.save(students);

		return "redirect:/students-home";

	}

	@GetMapping("/delete-student/{rollnum}")
	public String deleteStudent(@PathVariable int rollnum, Student students, Model model) {

		Student studentToDelete = studentRepository.findById(students.getRollnum()).get();

		System.out.println("Rollnum : " + rollnum);

		System.out.println("To Delete : " + studentToDelete);

		studentRepository.delete(studentToDelete);

		model.addAttribute("student", students);

		return "redirect:/students-home";

	}

	@RequestMapping("/update-student/{rollnum}")
	public String updateStudent(@PathVariable int rollnum, @ModelAttribute("students") Student student, Model model) {

		Student foundstudent = studentService.getOne(rollnum);

		System.out.println("Found Student : " + foundstudent);

		model.addAttribute("student", foundstudent);

		return "update.html";
	}

	@RequestMapping("/student/{id}")
	public String getOneStudent(@PathVariable("student") Student student, Model model) {

		Student studentInfo = studentService.getOne(student.getRollnum());

		model.addAttribute("student", studentInfo);

		return "student";
	}

	@RequestMapping("/find-students-by-rollnumber")
	public String getStudentByName(@ModelAttribute("student") Student student, Model model) throws Exception {

		int rollnum = student.getRollnum();

		model.addAttribute("studentwanted", studentService.getOne(rollnum));

		return "search-student";
	}

	@RequestMapping("/view-student/{rollnum}")
	public String getOne(@PathVariable int rollnum, @ModelAttribute("students") Student student, Model model) {
		String teacherName = null;

		Student oneStudent = studentRepository.getOne(student.getRollnum());

		System.out.println(oneStudent);

		List<TeacherModel> teacher = oneStudent.getTeacher();
		for (int i = 0; i < teacher.size(); i++) {
			teacherName = teacher.get(i).getTeacherName();
		}

		model.addAttribute("student", oneStudent);

		model.addAttribute("teacher", teacherName);

		return "student.html";
	}

}
