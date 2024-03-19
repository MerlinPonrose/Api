package RestAssured.RestAssured;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.restassured.excel.Api_excelread;
import com.restassured.utility.Common;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUT_Authorization {
	
	@Test(dataProvider="postdata")
	public void put(String id, String name, String email, String gender, String status)
	{
		
		RestAssured.baseURI="https://gorest.co.in/public/v2/users";
		
		RequestSpecification httprequest = RestAssured.given();
		
		httprequest.header("Content-Type", "application/json");
		
		String token = "d35afdaf334f8b6e975c19a88ea20f65f1b85e66465f76a0c1f6a26e68dfa8b7";
		
		httprequest.header("Authorization","Bearer "+token);
		
		JSONObject data = new JSONObject();
		data.put("name", name);
		data.put("email", email);
		data.put("gender", gender);
		data.put("status", status);
		
		httprequest.body(data);
		
		Response response = httprequest.request(Method.PUT,"/"+id);
		
		String res = response.getBody().asString();
		
		System.out.println(res);
		
		Common.getStatusCode(200);
		
	Common.validateStatusLine("HTTP/1.1 200 OK");
	
	Common.dataValidation("status", "active");
		
		
		
	}
	
	
	@DataProvider(name= "postdata")
	public Object[][] getData() throws IOException
	{
		return Api_excelread.excelread();
	}


}
