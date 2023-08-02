package com.one.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.project.models.ProductModel;
import com.one.project.repository.ProductRepository;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Product;

@Service
public class ProductService {

	String stripeKey = "sk_test_51M41IPSGWPh3rLePbzgIsi6m2cKizbU9pmsLMGnan8XvuMNUzBD8c9KNM8DEe7Tva4Fl6DJNHMSNy8ZEMhD8ULgD00eZ8iw2Se";

	@Autowired
	ProductRepository productRepository;

	ProductModel savedProduct;

	public Product addProductModel(ProductModel productModel) throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {

		Stripe.apiKey = stripeKey;
		Map<String, Object> params = new HashMap<>();
		params.put("name", productModel.getName());
		params.put("active", productModel.isActive());
//		params.put("description", null);
		Product product = Product.create(params);
		productModel.setId(product.getId());
		productRepository.save(productModel);
		return product;
	}
	
	public Product listProducts(String name) throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		Stripe.apiKey = stripeKey;
		ProductModel products = productRepository.getProductByName(name);
		Product product = Product.retrieve(products.getId());
		return product;
	}

}
