package com.one.project.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.one.project.models.PostModel;

public interface PostRepository extends JpaRepository<PostModel, Integer>{

	@Query(value = "select * from post_model p where p.students_rollnum=?1", nativeQuery = true)
	public List<PostModel> findAllDataPostedByStudent(int studentID);
	
}
