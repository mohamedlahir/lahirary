package com.one.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductModel {

	@Id
	private String id;

	private String name;

	private boolean active;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", active=" + active + "]";
	}

}
