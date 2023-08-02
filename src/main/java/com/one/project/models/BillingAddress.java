package com.one.project.models;

public class BillingAddress {
	private String billing_address;
	private String attention;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String state_code;
	private String fax;

	public String getBilling_address() {
		return billing_address;
	}

	public void setBilling_address(String billing_address) {
		this.billing_address = billing_address;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Override
	public String toString() {
		return "BillingAddress [billing_address=" + billing_address + ", attention=" + attention + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country + ", state_code="
				+ state_code + ", fax=" + fax + "]";
	}

}
