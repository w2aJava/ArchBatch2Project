package com.w2a.archBatch2.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FacebookLandingPage extends BasePage{
	
	/*public FacebookLandingPage(WebDriver driver)
	{
		System.out.println("driver-->"+driver);
		PageFactory.initElements(driver, this);
	}*/
	
	
	public  FacebookLandingPage open()
	{
		return (FacebookLandingPage) openPage(FacebookLandingPage.class);
	}
	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginButton);
	}
	
	/*@FindBy(how=How.ID,using="email")
	public WebElement userName;*/
	
	@FindBy(id="email")
	public WebElement userName;
	
	@FindBy(id="pass")
	public WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	public WebElement loginButton;

	public FacebookHomepage doLoginWithValidCredentials(String email,String pass)
	{
		userName.sendKeys(email);
		password.sendKeys(pass);
		loginButton.click();
		return (FacebookHomepage) openPage(FacebookHomepage.class);
	}
	
	public FacebookLandingPage doLoginWithInValidCredentials(String email,String pass)
	{
		userName.sendKeys(email);
		password.sendKeys(pass);
		loginButton.click();
		return this;
	}
	

	
}
