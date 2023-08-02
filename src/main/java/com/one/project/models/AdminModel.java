package com.one.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AdminModel {

	@Id
	private String paymentID;
	private String name;
	private String email;
	private String address;
	private String schoolName;
	private String schoolID;

	@Override
	public String toString() {
		return "AdminModel [paymentID=" + paymentID + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", schoolName=" + schoolName + ", schoolID=" + schoolID + "]";
	}

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}

}
