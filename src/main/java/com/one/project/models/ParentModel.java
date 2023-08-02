package com.one.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int parentID;

	private String fatherName;

	private String motherName;

//	@OneToMany
//	private Set<Student> student;

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

//	public Set<Student> getStudent() {
//		return student;
//	}
//
//	public void setStudent(Set<Student> student) {
//		this.student = student;
//	}

	@Override
	public String toString() {
		return "ParentModel [parentID=" + parentID + ", fatherName=" + fatherName + ", motherName=" + motherName + "]";
	}

}
