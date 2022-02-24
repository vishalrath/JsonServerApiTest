package com.bridgelabz;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonSeverApiTest {
	@Test
	public void getTest() {
		Response response = RestAssured.get("http://localhost:3000/posts");

		System.out.println("Response code: " + response.getStatusCode());
		response.prettyPrint();

	}
	@Test
	public void postTest() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.header("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 7);
		jsonObject.put("title", "QATest111");
		jsonObject.put("author", "myauthor11");
		requestSpecification.body(jsonObject.toJSONString());
		Response response = requestSpecification.post("http://localhost:3000/posts");
		System.out.println("responseCode: " +response.getStatusCode());
		response.prettyPrint();
		
	}
	
	@Test
	public void putTest() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.header("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		//jsonObject.put("id", 3);
		jsonObject.put("title", "QAauthor1");
		jsonObject.put("author", "Author15");
		requestSpecification.body(jsonObject.toJSONString());
		Response response = requestSpecification.put("http://localhost:3000/posts/3");
		System.out.println("responseCode: " +response.getStatusCode());
		response.prettyPrint();
		
	}
	@Test
	public void deleteTest() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.header("Content-Type", "application/json");
		Response response = requestSpecification.delete("http://localhost:3000/posts/2");
		System.out.println("responseCode: " +response.getStatusCode());
		response.prettyPrint();
		
	}
	
}
