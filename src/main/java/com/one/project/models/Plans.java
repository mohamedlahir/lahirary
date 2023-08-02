package com.one.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Plans {
	@Id
	int id;
	String plan_code;
	@Override
	public String toString() {
		return "Plans [id=" + id + ", plan_code=" + plan_code + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlan_code() {
		return plan_code;
	}
	public void setPlan_code(String plan_code) {
		this.plan_code = plan_code;
	}
	
	
}
