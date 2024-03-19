package RestAssured.RestAssured;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassured.excel.Api_excelread;
import com.restassured.utility.Common;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class POST_Authrizatin {
	
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
		
		Response respnse = httprequest.request(Method.POST);
		
	String res = respnse.getBody().asString();
		
		System.out.println(res);
		
		Common.getStatusCode(201);
		
		
	}
	
	
	@DataProvider(name= "postdata")
	public Object[][] getData() throws IOException
	{
		return Api_excelread.excelread();
	}

}
