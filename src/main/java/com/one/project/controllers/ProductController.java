package com.one.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.project.models.ProductModel;
import com.one.project.service.ProductService;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Product;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	// Add Product to the stripe Account.
	@RequestMapping("/add-product")
	public Product addProduct(@RequestBody ProductModel productModel) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException, APIException {

		return productService.addProductModel(productModel);
	}

	// Only if the name is unique
	@RequestMapping("/list-product/{name}")
	public Product listProduct(@PathVariable String name) throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return productService.listProducts(name);
	}

}
