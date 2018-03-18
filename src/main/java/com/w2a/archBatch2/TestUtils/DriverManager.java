package com.w2a.archBatch2.TestUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return DriverManager.driver.get() ;
	}

	public static void setDriver(WebDriver driver) {
		DriverManager.driver.set(driver);

}
	
	public static  void maximizeBrowser(WebDriver driver)
	{
		
		driver.manage().window().maximize();
	}
	
	public static  void setImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	
	
}
