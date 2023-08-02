package com.one.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Subscription {

	@Id
	String customer_id;
	String code;
	String message;
	@OneToOne
	Plans plans;

	@OneToOne
	HostedPageResponse hostedpage;

	public HostedPageResponse getHostedpage() {
		return hostedpage;
	}

	public void setHostedpage(HostedPageResponse hostedpage) {
		this.hostedpage = hostedpage;
	}

	@Override
	public String toString() {
		return "Subscription [customer_id=" + customer_id + ", code=" + code + ", message=" + message + ", plans="
				+ plans + ", hostedpage=" + hostedpage + "]";
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

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public Plans getPlans() {
		return plans;
	}

	public void setPlans(Plans plans) {
		this.plans = plans;
	}

}
