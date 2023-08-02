package com.one.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.project.models.ZohoSubscriptionTokenModel;

public interface SubscriptionTokenRepository extends JpaRepository<ZohoSubscriptionTokenModel, Integer> {

	
}
