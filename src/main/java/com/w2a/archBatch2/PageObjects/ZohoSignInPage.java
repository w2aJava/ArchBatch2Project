package com.w2a.archBatch2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoSignInPage extends BasePage{

	
	@FindBy(id="lid")
	public WebElement userName;	
	
	@FindBy(id="pwd")
	public WebElement password;
	
	@FindBy(id="signin_submit")
	public WebElement signInButton;
	
	@FindBy(xpath="//div[contains(text(),'Invalid password')]")
	public WebElement invalidPasswordErrorMsg;
	
	@FindBy(xpath="//div[contains(text(),'Please enter valid email / mobile')]")
	public WebElement invalidUsernameErrorMsg;
	
	
	public ZohoHomePage validateLoginWithValidCred(String userNameValue,String pwd)
	{
		type(userName, userNameValue, "userName");
		type(password, pwd, "password");
		click(signInButton, "signInButton");
		return (ZohoHomePage)openPage(ZohoHomePage.class);
		
		
		
		
	}
	
	public ZohoSignInPage validateLoginWithInValidCred(String userNameValue,String pwd)
	{
		type(userName, userNameValue, "userName");
		type(password, pwd, "password");
		click(signInButton, "signInButton");
		return this;
		
		
		
		
	}
	
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(signInButton);
	}

}
