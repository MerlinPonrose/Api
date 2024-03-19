package RestAssured.RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.utility.BaseClass;
import com.restassured.utility.Common;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Authrizatin extends BaseClass{

	@Test
	public static void getAuth(){
		// TODO Auto-generated method stub
		
		test = extent.createTest("GET_Authorization");
		
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		
		//specify request
		
		RequestSpecification httprequest = RestAssured.given();
		
		String tkn = "d35afdaf334f8b6e975c19a88ea20f65f1b85e66465f76a0c1f6a26e68dfa8b7";
		
		httprequest.header("Authorization","Bearer "+tkn);
		
		 respnse = httprequest.request(Method.GET,"/6134962");
		
		String res = respnse.getBody().asString();
		
		System.out.println(res);
		
	Common.getStatusCode(200);
	
	Common.validateStatusLine("HTTP/1.1 200 OK");
	
	Common.dataValidation("gender", "female");
	
	Common.dataValidation("status", "active");
	
	

	}
	
	@Test
	public void put()
	{
		
		test = extent.createTest("PUT_Authorization");
RestAssured.baseURI="https://gorest.co.in/public/v2/users";
		
		RequestSpecification httprequest = RestAssured.given();
		
		httprequest.header("Content-Type", "application/json");
		
		String token = "d35afdaf334f8b6e975c19a88ea20f65f1b85e66465f76a0c1f6a26e68dfa8b7";
		
		httprequest.header("Authorization","Bearer "+token);
		
		JSONObject data = new JSONObject();
		data.put("name","xx");
		data.put("email", "test@test.com");
		data.put("gender", "male");
		data.put("status", "active");
		
		httprequest.body(data);
		
		Response response = httprequest.request(Method.PUT,"/6134962");
		
		String res = response.getBody().asString();
		
		System.out.println(res);
		
		Common.getStatusCode(200);
		
	Common.validateStatusLine("HTTP/1.1 200 OK");
	
	
	}

}
