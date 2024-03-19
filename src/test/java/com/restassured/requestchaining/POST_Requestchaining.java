package com.restassured.requestchaining;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassured.excel.Api_excelread;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class POST_Requestchaining {
	
	@Test(dataProvider="postdata")
	public void POSAuth(String namee,String emaill,String genderr, String statuss){
		
		
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		
		//specify request
		
		RequestSpecification httprequest = RestAssured.given();
		
		String tkn = "d35afdaf334f8b6e975c19a88ea20f65f1b85e66465f76a0c1f6a26e68dfa8b7";
		
		httprequest.header("Authorization","Bearer "+tkn);
		
		httprequest.header("Content-Type","application/json");
		
		JSONObject input = new JSONObject();
		input.put("name", namee);
		input.put("email", emaill);
		input.put("gender", genderr);
		input.put("status", statuss);
		
		httprequest.body(input);
		
		Response post_respnse = httprequest.request(Method.POST);
		
	String res = post_respnse.getBody().asString();
		
		System.out.println("Post tresponse="+res);
		
		String id = post_respnse.getBody().jsonPath().getString("id");
		
	
RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		
		//specify request
		
		RequestSpecification httprequest1 = RestAssured.given();
		

		
		httprequest1.header("Authorization","Bearer "+tkn);
		
		Response respnse1 = httprequest.request(Method.GET,"/"+id);
		
		String res1 = respnse1.getBody().asString();
		
		System.out.println("Get response="+res1);
		
	

		
	}
	
	
	@DataProvider(name= "postdata")
	public Object[][] getData() throws IOException
	{
	//	System.out.println(Api_excelread.excelread());
		return Api_excelread.excelread();
	}



}
