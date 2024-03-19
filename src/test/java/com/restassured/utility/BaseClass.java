package com.restassured.utility;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.response.Response;

public class BaseClass {
	
	public static Response respnse;
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	
	@BeforeTest
	public void startreport()
	{
		 extent = new ExtentReports();
		 spark = new ExtentSparkReporter("Report/restassured.html");
		extent.attachReporter(spark);
	}
	
	
	@AfterTest
	public void endRAeport()
	{
		extent.flush();
	}

}
