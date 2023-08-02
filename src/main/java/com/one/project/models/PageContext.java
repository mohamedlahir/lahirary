package com.one.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PageContext {

	@Id
	int id;
	int Page;
	int per_page;
	boolean has_more_page;
	String applied_filter;
	String sort_column;
	String sort_order;
	public int getPage() {
		return Page;
	}
	public void setPage(int page) {
		Page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public boolean isHas_more_page() {
		return has_more_page;
	}
	public void setHas_more_page(boolean has_more_page) {
		this.has_more_page = has_more_page;
	}
	public String getApplied_filter() {
		return applied_filter;
	}
	public void setApplied_filter(String applied_filter) {
		this.applied_filter = applied_filter;
	}
	public String getSort_column() {
		return sort_column;
	}
	public void setSort_column(String sort_column) {
		this.sort_column = sort_column;
	}
	public String getSort_order() {
		return sort_order;
	}
	public void setSort_order(String sort_order) {
		this.sort_order = sort_order;
	}
	
	
}
