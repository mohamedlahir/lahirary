package com.one.project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PostModel {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int post_Id;
	private String content;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Student students;

	public int getPost_Id() {
		return post_Id;
	}

	public void setPost_Id(int post_Id) {
		this.post_Id = post_Id;
	}

	public Student getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students = students;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

//	public Student getStudents() {
//		return students;
//	}
//
//	public void setStudents(Student students) {
//		this.students = students;
//	}

	@Override
	public String toString() {
		return "PostModel [post_Id=" + post_Id + ", content=" + content + "]";
	}

}
