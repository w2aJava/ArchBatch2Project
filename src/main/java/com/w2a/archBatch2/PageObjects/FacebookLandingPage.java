package com.w2a.archBatch2.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FacebookLandingPage {
	
	public FacebookLandingPage(WebDriver driver)
	{
		System.out.println("driver-->"+driver);
		PageFactory.initElements(driver, this);
	}
	
	
	/*@FindBy(how=How.ID,using="email")
	public WebElement userName;*/
	
	@FindBy(id="email")
	public WebElement userName;
	
	@FindBy(id="pass")
	public WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	public WebElement loginButton;

	
}
