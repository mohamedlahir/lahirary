package com.one.project.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int rollnum;

	@Column(nullable = true)
	private String name;

	@Column(nullable = true)
	private String grade;

	@Column(nullable = true)
	private String section;

	@ManyToMany
	private List<TeacherModel> teacher;

	@ManyToOne
	private ParentModel parent;

	

	public ParentModel getParent() {
		return parent;
	}

	public void setParent(ParentModel parent) {
		this.parent = parent;
	}

	public int getRollnum() {
		return rollnum;
	}

	public void setRollnum(int rollnum) {
		this.rollnum = rollnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<TeacherModel> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<TeacherModel> teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [rollnum=" + rollnum + ", name=" + name + ", grade=" + grade + ", section=" + section
				+ ", teacher=" + teacher + ", parent=" + parent + "]";
	}

	
}