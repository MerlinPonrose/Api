package com.restassured.utility;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class Common extends BaseClass{
	
	
	public static void getStatusCode(int expectedStatus)
	{
	int statusCode = respnse.getStatusCode();
		
		if(statusCode==expectedStatus)
		{
			System.out.println("request success");
			test.log(Status.PASS, "request success");
		}
		else
		{
			System.out.println("error occured");
			test.log(Status.FAIL, "error occured");
		}
		
	}
	
	public static void validateStatusLine(String expectedStatusline)
	{
			String statusLine = respnse.getStatusLine();
		
		System.out.println(statusLine);
		
		Assert.assertEquals(statusLine, expectedStatusline);
		test.log(Status.PASS, "Status line validated");
	}
	
	public static void dataValidation(String key,String expectedvalue)
	{
		String ResponseBody = respnse.getBody().asString();
		if(ResponseBody!=null)
		{
			String genderrr = respnse.getBody().jsonPath().getString(key);
			
	//		Assert.assertEquals(genderrr, expectedvalue);
			
			if(genderrr.equals(expectedvalue))
			{
				System.out.println(key+""+expectedvalue+"value is avialble");
				test.log(Status.PASS, key+""+expectedvalue+ " value is avialble");
			}
			else
				
			{
				System.out.println(key+""+expectedvalue+"value not avialble");
				test.log(Status.FAIL, key+""+expectedvalue+ " value is not avialble");
			}
			
			
		}
		else
		{
			System.out.println("Response body not available");
		}
		
	
	}

}
