package com.w2a.archBatch2.setUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.w2a.archBatch2.TestUtils.DriverFactory;
import com.w2a.archBatch2.TestUtils.DriverManager;
import com.w2a.archBatch2.TestUtils.ExcelReader;

public class TestSetUp {

	// public WebDriver driver;
	public static Properties configProperty;
	public static Properties ORProperty;

	//
	public ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\simple.xlsx");

	@BeforeSuite
	public synchronized void beforeSuite() {
		try {
			FileInputStream fi = new FileInputStream(new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\propertyFIles\\config.properties"));
			configProperty = new Properties();
			try {
				configProperty.load(fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public void beforeClass() {
		// extent reporting
	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method) {

		WebDriver driver = null;

		if (driver == null) {
			// configProperty = PropertyFileManager.createConfigFileProperty();
			driver = DriverFactory.createDriverInstance(configProperty.getProperty("browser"));
			System.out.println("Driver-->" + DriverManager.getDriver());
			DriverManager.getDriver().navigate().to(configProperty.getProperty("url"));

		}

		/*
		 * ExtentTest child =
		 * classLevelReport.get().createNode(method.getName());
		 * testLevelReport.set(child); testLevelReport.get().log(Status.INFO,
		 * "Execution of Test Case-"+" "+method.getName()+" started");
		 */
	}

	@AfterMethod
	public void afterMethod() {
		// DriverFactory.destroyDriver();
	}

	@AfterClass
	public void afterClass() {
		//
	}

	@AfterTest
	public void afterTest() {

	}
	//

	@AfterSuite
	public void afterSuite() {
		//
	}

}
