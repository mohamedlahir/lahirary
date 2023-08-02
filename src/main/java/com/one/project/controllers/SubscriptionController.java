package com.one.project.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.one.project.models.Subscription;
import com.one.project.models.ZohoProductResponse;
import com.one.project.models.ZohoSubscriptionTokenModel;
import com.one.project.repository.SubscriptionTokenRepository;
import com.one.project.service.SubscriptionTokenService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@RestController
public class SubscriptionController {

	@Autowired
	SubscriptionTokenService tokenService;

	@Autowired
	SubscriptionTokenRepository tokenRepo;

	@GetMapping("/zoho")
	public String zohoRoot() {

		return "Hello Zoho";
	}

	@PostMapping("/zoho/savetoken")
	public ZohoSubscriptionTokenModel saveToken() throws IOException {

		return tokenService.saveToken();
	}

	@PostMapping("/zoho/refreshtoken")
	public ZohoSubscriptionTokenModel refreshToken() throws JsonMappingException, JsonProcessingException, IOException {

		return tokenService.refreshToken();

	}

	@PostMapping("/zoho/create-product")
	public ZohoProductResponse productCreation(@RequestBody String data) throws IOException {

		return tokenService.createProduct(data);
	}

	@GetMapping("/zoho/getallproduct")
	public Response getAllProduct() throws IOException {

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("https://www.zohoapis.in/subscriptions/v1/products").get()
				.addHeader("X-com-zoho-subscriptions-organizationid", "60022628714")
				.addHeader("Authorization",
						"Zoho-oauthtoken 1000.3c073946c937cf9edf056c2602f71a70.dcd440e9967c091c8989e4c0ec3f8120")
				.build();
		Response response = client.newCall(request).execute();
		System.out.println(response);
		return response;
	}

	@PostMapping("/zoho/create-customer")
	public Response createCustomer(@RequestBody String customer) throws IOException {

		return tokenService.createCustomer(customer);
	}

	@GetMapping("/getallcustomer")
	public Response getAllCustomer() throws IOException {
		return tokenService.listOfAllCustomer();
	}

	@PostMapping("/createplan")
	public Response createPlans(@RequestBody String data) throws IOException {

		return tokenService.createPlan(data);
	}

	@GetMapping("/getallproducts")
	public ZohoProductResponse getAllProducts() throws IOException {

		return tokenService.getAllProducts();
	}
	
	@PostMapping("/existinghostedpage")
	public Subscription xyz(@RequestBody String data) throws IOException {
		
		return tokenService.xyz(data);
	}

//	@GetMapping("/time")
//	public boolean time() {
//		
//		return tokenService.timeCheck();
//	}
}
