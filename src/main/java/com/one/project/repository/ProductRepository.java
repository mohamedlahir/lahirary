package com.one.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.project.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, String> {
	
	public ProductModel getProductByName(String name);

}
