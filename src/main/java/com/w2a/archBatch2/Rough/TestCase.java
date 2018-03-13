package com.w2a.archBatch2.Rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.archBatch2.PageObjects.FacebookLandingPage;

public class TestCase {

	@Test(dataProvider = "getData")
	public static void doLogin(String userName, String password) {
		System.out.println("Author of doLogin Test is Rahul");
		System.out.println("doLogin test case execution starts");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FacebookLandingPage fbHomePage=new FacebookLandingPage(driver);
		fbHomePage.userName.sendKeys(userName);
		fbHomePage.password.sendKeys(password);
		fbHomePage.loginButton.click();
		// logging in case of failure
		driver.close();
		driver.quit();
		System.out.println("doLogin test case pass");

	}

	/*@Test(dataProvider = "getData")
	public static void createAccount(String userName, String password) {
		System.out.println("Author of doLogin Test is Raman");
		System.out.println("createAccount test case execution starts");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("firstname")).sendKeys(userName);
		System.out.println("Entered Rahul as firstName");
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		// logging in case of failure
		driver.close();
		driver.quit();
		System.out.println("createAccount test case pass");
		// methods to log--> click, type, select, navigate
	}
*/
	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][2];
		data[0][0] = "Rahsdfsdful";
		data[0][1] = "sdf";
		//read external File
		return data;

	}
}