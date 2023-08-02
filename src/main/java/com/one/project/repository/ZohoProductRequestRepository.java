package com.one.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.project.models.ZohoProductRequest;

public interface ZohoProductRequestRepository extends JpaRepository<ZohoProductRequest, Integer> {

	public ZohoProductRequest findByName(String name);
	
}
