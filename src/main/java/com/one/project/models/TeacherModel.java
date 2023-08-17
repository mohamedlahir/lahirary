package com.one.project.models;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TeacherModel {

	@Id
	private int teacherID;

	@Column(name="teacher_name", nullable = false)
	private String teacherName;

	@Column(nullable = false)
	private String subjectsHandling[];
	
	@Column(nullable = false)
	private String classesHandling[];

	public int getTeacherID() {
		return teacherID;
	}

	public String[] getSubjectsHandling() {
		return subjectsHandling;
	}

	public void setSubjectsHandling(String[] subjectsHandling) {
		this.subjectsHandling = subjectsHandling;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String[] getClassesHandling() {
		return classesHandling;
	}

	public void setClassesHandling(String[] classesHandling) {
		this.classesHandling = classesHandling;
	}

	@Override
	public String toString() {
		return "TeacherModel [teacherID=" + teacherID + ", teacherName=" + teacherName + ", subjectsHandling="
				+ Arrays.toString(subjectsHandling) + ", classesHandling=" + Arrays.toString(classesHandling) + "]";
	}
}
