package com.one.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.one.project.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByrollnum(int rollnum);

	@Query(value = "select * from student s where s.name like %:keyword%", nativeQuery = true)
	List<Student> findByKeyWord(@Param("keyword") String keyword);

}
