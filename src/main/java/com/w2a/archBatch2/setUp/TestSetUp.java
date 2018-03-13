package com.w2a.archBatch2.setUp;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestSetUp {
	
	public  WebDriver driver;
	public  Properties configProperty;
	public  Properties ORProperty;
	
	@BeforeSuite
	public void beforeSuite()
	{
		// excelreader class instantiation
		//property file instantiation
		//extent report --> object
		
	}
	@BeforeTest
	public void beforeTest()
	{
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		//extent reporting
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		//logging
		//webdriver
		//extent report
	}
	@AfterMethod
	public void afterMethod()
	{
		//browser close
		//testlink update
		//extent report flush
	}
	
	
	@AfterClass
	public void afterClass()
	{
		//
	}
	
	
	
	@AfterTest
	public void afterTest()
	{
		
	}
	//
	
	@AfterSuite
	public void afterSuite()
	{
		//
	}

}
