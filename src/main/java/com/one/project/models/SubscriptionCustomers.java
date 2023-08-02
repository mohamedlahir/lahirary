package com.one.project.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SubscriptionCustomers {

	@Id
	int id;
	String displayName;
	String email;
	String password;
	boolean isSubscribed;
	Date subscribedData;

	@Override
	public String toString() {
		return "SubscriptionCustomers [id=" + id + ", displayName=" + displayName + ", email=" + email + ", password="
				+ password + ", isSubscribed=" + isSubscribed + ", subscribedData=" + subscribedData + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

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

	public boolean isSubscribed() {
		return isSubscribed;
	}

	public void setSubscribed(boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
	}

	public Date getSubscribedData() {
		return subscribedData;
	}

	public void setSubscribedData(Date subscribedData) {
		this.subscribedData = subscribedData;
	}

}
