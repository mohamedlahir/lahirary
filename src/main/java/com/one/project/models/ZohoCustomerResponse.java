package com.one.project.models;

import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZohoCustomerResponse {

//	private String id;
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
	private boolean is_portal_enabled;
	private String zcrm_account_id;

	private String zcrm_contact_id;
	private Date updated_time;
	private Date created_time;

	private String currency_code;
	private boolean ach_supported;
	private String message;
	private String display_name;
	private String company_name;
	private String customer_id;
	private String contact_id;
	private String status;
	private String customer_sub_type;
	private String currency_id;
	private String is_client_review_asked;
	private String is_client_review_settings_enabled;
	private String source;
	private String payment_reminder_enabled;
	private String language_code;
	private String portal_status;
	private String owner_id;
	private String language_code_formatted;
	
	

	public String getZcrm_account_id() {
		return zcrm_account_id;
	}

	public void setZcrm_account_id(String zcrm_account_id) {
		this.zcrm_account_id = zcrm_account_id;
	}

	public String getZcrm_contact_id() {
		return zcrm_contact_id;
	}

	public void setZcrm_contact_id(String zcrm_contact_id) {
		this.zcrm_contact_id = zcrm_contact_id;
	}

	public Date getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(Date updated_time) {
		this.updated_time = updated_time;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
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

	public boolean isIs_portal_enabled() {
		return is_portal_enabled;
	}

	public void setIs_portal_enabled(boolean is_portal_enabled) {
		this.is_portal_enabled = is_portal_enabled;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	public boolean isAch_supported() {
		return ach_supported;
	}

	public void setAch_supported(boolean ach_supported) {
		this.ach_supported = ach_supported;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getContact_id() {
		return contact_id;
	}

	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomer_sub_type() {
		return customer_sub_type;
	}

	public void setCustomer_sub_type(String customer_sub_type) {
		this.customer_sub_type = customer_sub_type;
	}

	public String getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}

	public String getIs_client_review_asked() {
		return is_client_review_asked;
	}

	public void setIs_client_review_asked(String is_client_review_asked) {
		this.is_client_review_asked = is_client_review_asked;
	}

	public String getIs_client_review_settings_enabled() {
		return is_client_review_settings_enabled;
	}

	public void setIs_client_review_settings_enabled(String is_client_review_settings_enabled) {
		this.is_client_review_settings_enabled = is_client_review_settings_enabled;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPayment_reminder_enabled() {
		return payment_reminder_enabled;
	}

	public void setPayment_reminder_enabled(String payment_reminder_enabled) {
		this.payment_reminder_enabled = payment_reminder_enabled;
	}

	public String getLanguage_code() {
		return language_code;
	}

	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}

	public String getPortal_status() {
		return portal_status;
	}

	public void setPortal_status(String portal_status) {
		this.portal_status = portal_status;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getLanguage_code_formatted() {
		return language_code_formatted;
	}

	public void setLanguage_code_formatted(String language_code_formatted) {
		this.language_code_formatted = language_code_formatted;
	}

	@Override
	public String toString() {
		return "ZohoCustomerResponse [email=" + email + ", salutation=" + salutation + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", tags=" + Arrays.toString(tags) + ", code=" + code + ", phone=" + phone
				+ ", mobile=" + mobile + ", department=" + department + ", designation=" + designation + ", website="
				+ website + ", is_portal_enabled=" + is_portal_enabled + ", currency_code=" + currency_code
				+ ", ach_supported=" + ach_supported + ", message=" + message + ", display_name=" + display_name
				+ ", company_name=" + company_name + ", customer_id=" + customer_id + ", contact_id=" + contact_id
				+ ", status=" + status + ", customer_sub_type=" + customer_sub_type + ", currency_id=" + currency_id
				+ ", is_client_review_asked=" + is_client_review_asked + ", is_client_review_settings_enabled="
				+ is_client_review_settings_enabled + ", source=" + source + ", payment_reminder_enabled="
				+ payment_reminder_enabled + ", language_code=" + language_code + ", portal_status=" + portal_status
				+ ", owner_id=" + owner_id + ", language_code_formatted=" + language_code_formatted + "]";
	}

}
