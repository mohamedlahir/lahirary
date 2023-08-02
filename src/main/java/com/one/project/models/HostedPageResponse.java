package com.one.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HostedPageResponse {

	@Id
	String hostedpage_id;
	String decrypted_hosted_page_id;
	String status;
	String url;
	String action;
	String expiring_time;
	String created_time;

	@Override
	public String toString() {
		return "HostedPageResponse [hostedpage_id=" + hostedpage_id + ", decrypted_hosted_page_id="
				+ decrypted_hosted_page_id + ", status=" + status + ", url=" + url + ", action=" + action
				+ ", expiring_time=" + expiring_time + ", created_time=" + created_time + "]";
	}

	public String getHostedpage_id() {
		return hostedpage_id;
	}

	public void setHostedpage_id(String hostedpage_id) {
		this.hostedpage_id = hostedpage_id;
	}

	public String getDecrypted_hosted_page_id() {
		return decrypted_hosted_page_id;
	}

	public void setDecrypted_hosted_page_id(String decrypted_hosted_page_id) {
		this.decrypted_hosted_page_id = decrypted_hosted_page_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getExpiring_time() {
		return expiring_time;
	}

	public void setExpiring_time(String expiring_time) {
		this.expiring_time = expiring_time;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

}
