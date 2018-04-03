package com.w2a.archBatch2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoHomePage extends BasePage{

	@FindBy(xpath="//*[contains(text(),'CRMMM')]")
	public WebElement crm;
	
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(crm);
	}

}
