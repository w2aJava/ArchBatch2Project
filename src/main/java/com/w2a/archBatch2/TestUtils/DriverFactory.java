package com.w2a.archBatch2.TestUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static String chromeExeFilePath;
	public static String ieExeFilePath;
	public static String firefoxExeFilePath;

	public static String getChromeExeFilePath() {
		return chromeExeFilePath;
	}

	public static void setChromeExeFilePath(String chromeExeFilePath) {
		DriverFactory.chromeExeFilePath = chromeExeFilePath;
	}

	public static String getIeExeFilePath() {
		return ieExeFilePath;
	}

	public static void setIeExeFilePath(String ieExeFilePath) {
		DriverFactory.ieExeFilePath = ieExeFilePath;
	}

	public static String getFirefoxExeFilePath() {
		return firefoxExeFilePath;
	}

	public static void setFirefoxExeFilePath(String firefoxExeFilePath) {
		DriverFactory.firefoxExeFilePath = firefoxExeFilePath;
	}
	
	public static WebDriver createDriverInstance(String browserName)
	{
		WebDriver driver =null;
		if(System.getProperty("os.name").contains("Windows")){
		if(browserName.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", DriverFactory.getFirefoxExeFilePath());
			driver=new FirefoxDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(driver);
			DriverManager.setImplicitWait(driver);
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeExeFilePath());
			driver=new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(driver);
			DriverManager.setImplicitWait(driver);
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", DriverFactory.getIeExeFilePath());
			driver=new InternetExplorerDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(driver);
			DriverManager.setImplicitWait(driver);
		}
		
	}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			
		}
		return DriverManager.getDriver();
			
	}

	
	
	public static void destroyDriver()
	{
		if(DriverManager.getDriver()!=null)
			DriverManager.getDriver().quit();
	}
}
