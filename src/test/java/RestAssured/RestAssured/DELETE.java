package RestAssured.RestAssured;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETE {
	
	@Test
	public void delete()
	{
		RestAssured.baseURI="https://gorest.co.in/public/v2/users";
		
		RequestSpecification httprequest = RestAssured.given();
		
		String token = "d35afdaf334f8b6e975c19a88ea20f65f1b85e66465f76a0c1f6a26e68dfa8b7";
		
		httprequest.header("Authorization","Bearer "+token);
		
		Response request = httprequest.request(Method.DELETE,"/6101028");
		
		int statusCode = request.getStatusCode();
		
		System.out.println(statusCode);
		
		String statusLine = request.statusLine();
		
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(statusLine, "HTTP/1.1 204 OK");
		
	System.out.println("next line");
	
	soft.assertAll();
		
	}

}
