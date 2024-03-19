package RestAssured.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestAssured_GET {
	
	
	@Test
	public void GET()
	{
		
		// Request 
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		RequestSpecification httprequest = RestAssured.given();
		
		//Sending the request
		
		Response response = httprequest.request(Method.GET);
		
		//Vaidatin
		
	String res_body =	response.getBody().asString();
	
	System.out.println(res_body);
	
	int statusCode = response.getStatusCode();
	
	System.out.println(statusCode);
		
	//Assert.assertEquals(statusCode, "200");
	
	String statusLine = response.getStatusLine();
	
	System.out.println(statusLine);
	
	String frstname = response.getBody().jsonPath().getString("data[0].first_name");
	System.out.println(frstname);
	
	if(frstname.equals("George"))
	{
		System.out.println("Frst name is equal");
	}
	else
	{
		System.out.println("Frst name is nt equal");
		Assert.fail();
	}
	
	}

}
