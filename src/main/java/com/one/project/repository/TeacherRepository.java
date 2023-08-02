package com.one.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.project.models.TeacherModel;

public interface TeacherRepository extends JpaRepository<TeacherModel, Integer> {

	
	
}
