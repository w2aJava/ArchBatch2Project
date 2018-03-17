package com.w2a.archBatch2.setUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import com.w2a.archBatch2.TestUtils.ExcelReader;

public class TestSetUp {

	public static  WebDriver driver;
	public Properties configProperty;
	public Properties ORProperty;

	//
	public ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\simple.xlsx");

	@BeforeSuite
	public void beforeSuite() {
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
	public void beforeMethod() {
	//	driver = null;
		if (driver == null) {

			if (configProperty.getProperty("browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (configProperty.getProperty("browser").equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
		}
		System.out.println("driver-->"+driver);
		driver.navigate().to(configProperty.getProperty("url"));
	}

	@AfterMethod
	public void afterMethod() {
		// browser close
		// testlink update
		// extent report flush
		driver.quit();
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
