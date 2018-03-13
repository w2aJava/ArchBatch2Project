package com.w2a.archBatch2.Rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestCase2 {

	

	@Test(dataProviderClass=TestCase.class,dataProvider="getData")
	public static void validateUploadProfilePicture(String userName,String password) {
		System.out.println("Author of doLogin Test is Rahul");
		System.out.println("validateUploadProfilePicture test case execution starts");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		// logging in case of failure
		driver.close();
		driver.quit();
		System.out.println("validateUploadProfilePicture test case pass");
		
	}
}
