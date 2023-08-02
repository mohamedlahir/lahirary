package com.one.project.models;

import java.util.Arrays;

import com.one.project.controllers.ShippingAddress;

import jakarta.persistence.Id;

public class ZohoCustomerRequest {

	@Id
	private String email;
	private String salutation;
	private String first_name;
	private String last_name;
	private String tags[];
	private String code;
	private String phone;
	private String mobile;
	private String department;
	private String designation;
	private String website;

	private BillingAddress billingAddress;
	private ShippingAddress shippingAddress;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "ZohoCustomerRequest [email=" + email + ", salutation=" + salutation + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", tags=" + Arrays.toString(tags) + ", code=" + code + ", phone=" + phone
				+ ", mobile=" + mobile + ", department=" + department + ", designation=" + designation + ", website="
				+ website + ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress + "]";
	}

}
