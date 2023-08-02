package com.one.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.project.models.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, String>{

}
