package com.w2a.archBatch2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoSignUpPage extends BasePage{

	
	@FindBy(id="emailfield")
	public WebElement userEmail;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="signupbtn")
	public WebElement signUpButton;
	
	@FindBy(id="signup-termservice")
	public WebElement agreeToServiceTerm;
	
	
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(signUpButton);
	}
	
	public ZohoHomePage doSingnupWithValidCred(String email,String pwd)
	{
		type(userEmail, email, "userEmail");
		type(password, pwd, "password");
		click(agreeToServiceTerm, "agreeToServiceTerm checkbox");
		click(signUpButton, "signUpButton");
		return (ZohoHomePage) openPage(ZohoHomePage.class);
		
		
	}

}
