package com.one.project.models;

public class LoginRequest {

	private String email;
	private String password;
	private String message;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LoginRequest [email=" + email + ", password=" + password + ", message=" + message + "]";
	}

}
