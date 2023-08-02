package com.one.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.project.models.ParentModel;

public interface ParentRepository extends JpaRepository<ParentModel, Integer>{

}
