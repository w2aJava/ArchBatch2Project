package com.w2a.archBatch2.Rough;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestGrid {
	
	
	public static void main(String[] args) throws MalformedURLException {

		String hubURL="http://localhost:4444/wd/hub";
		DesiredCapabilities cap= DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		//cap.setPlatform(Platform.ANY);
		WebDriver driver=new RemoteWebDriver(new URL(hubURL), cap);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("sdasdad");
		driver.findElement(By.id("pass")).sendKeys("sdasdad");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		driver.quit();
		
	}

}
