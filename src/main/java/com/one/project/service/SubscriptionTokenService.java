package com.one.project.service;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.project.models.Subscription;
import com.one.project.models.ZohoCustomerResponse;
import com.one.project.models.ZohoProductRequest;
import com.one.project.models.ZohoProductResponse;
import com.one.project.models.ZohoSubscriptionTokenModel;
import com.one.project.repository.StudentRepository;
import com.one.project.repository.SubscriptionRepository;
import com.one.project.repository.SubscriptionTokenRepository;
import com.one.project.repository.ZohoProductRequestRepository;
import com.one.project.repository.ZohoProductResonseRepository;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

@Service
public class SubscriptionTokenService {

	@Autowired
	SubscriptionTokenRepository subscriptionTokenRepo;

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	SubscriptionRepository src;

	@Autowired
	ZohoProductResonseRepository zohoProductResponseRepo;

	@Autowired
	ZohoProductRequestRepository zohoProductRequestRepository;

	ZohoSubscriptionTokenModel model;

	ZohoProductRequest product;

	ZohoCustomerResponse customer;

	String product_url = "https://www.zohoapis.in/subscriptions/v1/products";

	String createCustomerURL = "https://www.zohoapis.in/subscriptions/v1/customers";

	String code = "code=1000.93634882350f3804eb2bc865cc7ef125.57b49a7e16cef6bda262eda778153d77";

	String client_id = "client_id=1000.ISJ1O1CRSZLD9EG0SBCKP4QDK24OBM";

	String client_secret = "client_secret=77bfe5bbe6a776cdfe30c86e7e3b27486750a1d1f9";

	String redirect_uri = "redirect_uri=http://localhost:8080/zoho";

	String grant_type = "grant_type=authorization_code";

	String grant_type_refresh = "grant_type=" + "refresh_token";

	String organisationID = "60022909730";

	public ZohoSubscriptionTokenModel saveToken() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "");
		Request request = new Request.Builder().url("https://accounts.zoho.in/oauth/v2/token?" + code + "&" + client_id
				+ "&" + client_secret + "&" + redirect_uri + "&" + grant_type).post(body).build();
		ResponseBody responseBody = client.newCall(request).execute().body();
		System.out.println(responseBody);
		System.out.println(model);
		ZohoSubscriptionTokenModel model = objectMapper.readValue(responseBody.string(),
				ZohoSubscriptionTokenModel.class);
		model.setScope(null);
		subscriptionTokenRepo.save(model);
		System.out.println(responseBody);
		return model;
	}

	public ZohoSubscriptionTokenModel refreshToken() throws JsonMappingException, JsonProcessingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "");
		String refresh_token = "refresh_token=" + subscriptionTokenRepo.findById(0).get().getRefresh_token();
		Request request = new Request.Builder().url("https://accounts.zoho.in/oauth/v2/token?" + refresh_token + "&"
				+ client_id + "&" + client_secret + "&" + redirect_uri + "&" + grant_type_refresh).post(body).build();
		ResponseBody responseBody = client.newCall(request).execute().body();
		System.out.println(responseBody);
		System.out.println(model);

		ZohoSubscriptionTokenModel model = objectMapper.readValue(responseBody.string(),
				ZohoSubscriptionTokenModel.class);

		model.setScope(null);

		ZohoSubscriptionTokenModel existingModel = subscriptionTokenRepo.findById(0).get();

		existingModel.setId(0);

		existingModel.setAccess_token(model.getAccess_token());
		existingModel.setApi_domain(model.getApi_domain());
		existingModel.setRefresh_token(refresh_token.substring(14));
		existingModel.setError(model.getError());
		existingModel.setExpires_in(model.getExpires_in());
		existingModel.setScope(model.getScope());
		existingModel.setToken_type(model.getToken_type());
		subscriptionTokenRepo.save(existingModel);
		System.out.println(existingModel);
		return existingModel;
	}

	public Response createCustomer(String customer) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, customer);
		Request request = new Request.Builder().url(createCustomerURL).post(body)
				.addHeader("X-com-zoho-subscriptions-organizationid", "60022909730")
				.addHeader("Authorization",
						"Zoho-oauthtoken " + subscriptionTokenRepo.findById(0).get().getAccess_token())
				.addHeader("content-type", "application/json").build();
		Response response = client.newCall(request).execute();
		System.out.println(customer);
		return response;
	}

	public Response listOfAllCustomer() throws IOException {
		OkHttpClient client = new OkHttpClient();
		ObjectMapper objectMapper = new ObjectMapper();
		Request request = new Request.Builder().url("https://www.zohoapis.in/subscriptions/v1/customers").get()
				.addHeader("X-com-zoho-subscriptions-organizationid", organisationID).addHeader("Authorization",
						"Zoho-oauthtoken " + subscriptionTokenRepo.findById(0).get().getAccess_token())
				.build();
		Response response = client.newCall(request).execute();

		ResponseBody responseBody = client.newCall(request).execute().body();
		ZohoCustomerResponse model = objectMapper.readValue(responseBody.toString(), ZohoCustomerResponse.class);
		return response;
	}

	public Response createPlan(String data) throws IOException {

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, data);
		Request request = new Request.Builder().url("https://www.zohoapis.com/subscriptions/v1/plans").post(body)
				.addHeader("X-com-zoho-subscriptions-organizationid", organisationID)
				.addHeader("Authorization",
						"Zoho-oauthtoken " + subscriptionTokenRepo.findById(0).get().getAccess_token())
				.addHeader("content-type", "application/json").build();

		Response response = client.newCall(request).execute();

		return response;
	}

	public ZohoProductResponse createProduct(String data) throws IOException {

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, data);
		System.out.println("Data : " + data);
		Request request = new Request.Builder().url(product_url).post(body)
				.addHeader("X-com-zoho-subscriptions-organizationid", organisationID)
				.addHeader("Authorization",
						"Zoho-oauthtoken " + subscriptionTokenRepo.findById(0).get().getAccess_token())
				.addHeader("content-type", "application/json").build();
//		Response response = client.newCall(request).execute();
		ResponseBody responseBody = client.newCall(request).execute().body();

		ObjectMapper objectMapper = new ObjectMapper();
		ZohoProductResponse model = objectMapper.readValue(responseBody.string(), ZohoProductResponse.class);

		System.out.println("Model product" + model.getProduct());

		System.out.println("Product : " + model.getProduct());

		System.out.println("Access Token : " + subscriptionTokenRepo.findById(0).get().getAccess_token());
		model.setProduct(model.getProduct());

		zohoProductRequestRepository.save(model.getProduct());
		zohoProductResponseRepo.save(model);

		return model;
	}

	public ZohoProductResponse getAllProducts() throws IOException {

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url("https://www.zohoapis.in/subscriptions/v1/products").get()
				.addHeader("X-com-zoho-subscriptions-organizationid", organisationID).addHeader("Authorization",
						"Zoho-oauthtoken " + subscriptionTokenRepo.findById(0).get().getAccess_token())
				.build();

		System.out.println("Access Token : " + subscriptionTokenRepo.findById(0).get().getAccess_token());

		ResponseBody response = client.newCall(request).execute().body();
		ObjectMapper objectMapper = new ObjectMapper();
		ZohoProductResponse model = objectMapper.readValue(response.string(), ZohoProductResponse.class);

		return model;
	}

	public Subscription xyz(String data) throws IOException {

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, data);
		Request request = new Request.Builder().url("https://subscriptions.zoho.in/api/v1/hostedpages/newsubscription")
				.post(body).addHeader("X-com-zoho-subscriptions-organizationid", "60017500429")
				.addHeader("Authorization",
						"Zoho-oauthtoken " + "1000.78d0a7a5bdbad484a971b26b4db9f207.9c1bfe5c2e708f44cfc08807c7220417")
				.addHeader("content-type", "application/json").build();
		ResponseBody response = client.newCall(request).execute().body();
		ObjectMapper objectMapper = new ObjectMapper();
		Subscription model = objectMapper.readValue(response.string(), Subscription.class);
		model.setCustomer_id("1");
		src.save(model);
		return model;
	}
	
//	public boolean timeCheck() {
//
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		try {
//
//			String time = studentRepo.findById(1).get().getDate();
//
//			// Parse the time to a Date object
//			Date dateToCheck = sdf.parse(time);
//
//			System.out.println(dateToCheck);
//
//			System.out.println(studentRepo.findById(1).get().getDate());
//
//			// Get the current time
//			Date currentTime = new Date();
//
//			// Calculate the time difference in milliseconds
//			long timeDifference = dateToCheck.getTime() - currentTime.getTime();
//
//			System.out.println("Date to Check : " + dateToCheck + " Current Time : " + currentTime + "Difference :"
//					+ timeDifference);
//
//			// Check if the time difference is more than an hour (3600000 milliseconds)
//			return timeDifference > 3600000;
//		} catch (ParseException e) {
//			// Handle the exception if the time is in the wrong format
//			System.out.println("Wrong Format Unable to parse");
//			e.printStackTrace();
//			return false;
//		}
//	}
}
