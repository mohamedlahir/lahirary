package com.one.project.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@JsonIgnoreProperties
public class ZohoProductResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String code;
	String message;

	@OneToOne(cascade = CascadeType.ALL)
	ZohoProductRequest product;

	@OneToMany(cascade = CascadeType.ALL)
	List<ZohoProductRequest> products;

	@OneToOne
	PageContext page_context;

	public PageContext getPage_context() {
		return page_context;
	}

	public void setPage_context(PageContext page_context) {
		this.page_context = page_context;
	}

	public List<ZohoProductRequest> getProducts() {
		return products;
	}

	public void setProducts(List<ZohoProductRequest> products) {
		this.products = products;
	}

	public ZohoProductRequest getProduct() {
		return product;
	}

	public void setProduct(ZohoProductRequest product) {
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ZohoProductResponse [id=" + id + ", code=" + code + ", message=" + message + ", product=" + product
				+ ", products=" + products + ", page_context=" + page_context + "]";
	}

}
