package com.one.project.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.project.models.ParentModel;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Balance;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.net.RequestOptions;

@RestController
public class StripeController {

	String stripeKey = "sk_test_51M41IPSGWPh3rLePbzgIsi6m2cKizbU9pmsLMGnan8XvuMNUzBD8c9KNM8DEe7Tva4Fl6DJNHMSNy8ZEMhD8ULgD00eZ8iw2Se";

	@RequestMapping("/auth")
	public Customer auth() throws AuthenticationException, InvalidRequestException, APIConnectionException,
			CardException, APIException {
		RequestOptions requestOptions = RequestOptions.builder().setApiKey(stripeKey).build();
		Customer customer = Customer.retrieve("cus_NyIVswG1S15PmH", requestOptions);
		return customer;
	}

//	@RequestMapping("/create-customer")
//	public ParentModel createCustomer(@RequestBody ParentModel parent) throws AuthenticationException,
//			InvalidRequestException, APIConnectionException, CardException, APIException {
//		Stripe.apiKey = stripeKey;
//		System.out.println(stripeKey);
//		Map<String, Object> params = new HashMap<>();
//		params.put("name", parent.getName());
//		params.put("email", parent.getEmail());
//		Customer customer = Customer.create(params);
//		parent.setPaymentID(customer.getId());
//		return parent;
//	}

	@RequestMapping("/balance")
	public Balance balanceCheck() throws AuthenticationException, InvalidRequestException, APIConnectionException,
			CardException, APIException {
		Stripe.apiKey = stripeKey;
		Balance balance = Balance.retrieve();
		return balance;
	}

	@RequestMapping("/add-credit-card")
	public Balance addCreditCard() throws AuthenticationException, InvalidRequestException, APIConnectionException,
			CardException, APIException {
		Stripe.apiKey = stripeKey;

		return null;
	}

	@RequestMapping("/list-all-customers/{limit}")
	public CustomerCollection listAllCustomer(@PathVariable int limit) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException, APIException {
		Stripe.apiKey = stripeKey;
		Map<String, Object> params = new HashMap<>();
		params.put("limit", limit);
		CustomerCollection customers = Customer.list(params);

		return customers;
	}

	@RequestMapping("/create-time-table/{classID}")
	public void createTimeTable() {

	}

}
