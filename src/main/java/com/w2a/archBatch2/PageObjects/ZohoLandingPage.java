package com.w2a.archBatch2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoLandingPage extends BasePage{

	@FindBy(className="signin")
	public WebElement loginButton;
	
	@FindBy(className="signup")
	public WebElement signUpButton;
	
	
	public  ZohoLandingPage open()
	{
		return (ZohoLandingPage) openPage(ZohoLandingPage.class);
	}
	
	public ZohoSignInPage clickOnLoginButton()
	{
		click(loginButton, "loginButton");
		return (ZohoSignInPage)openPage(ZohoSignInPage.class);
		
	}
	
	public ZohoSignUpPage clickOnSignUpButton()
	{
		click(signUpButton, "signUpButton");
		return (ZohoSignUpPage)openPage(ZohoSignUpPage.class);
		
	}
	
	
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(loginButton);
	}

}
